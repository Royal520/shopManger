package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.Ledger;
import com.hubu.gl.Entity.Message;
import com.hubu.gl.Entity.Product;
import com.hubu.gl.Entity.Stock;
import com.hubu.gl.Entity.rep.CountPoduct;
import com.hubu.gl.dao.mapper.LedgerMapper;
import com.hubu.gl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Lovejj
 * @version 1.0
 * @description: 台账模块
 * @date 2023/6/28 上午12:03
 */
@Service
public class LedgerServiceImpl extends ServiceImpl<LedgerMapper, Ledger> implements ILedgerService {

    @Autowired
    IStockService stockService;
    @Autowired
    IProductService productService;
    @Autowired
    IProductSkuService skuService;
    @Autowired
    IMessageService messageService;
    @Autowired
    RedisTemplate redisTemplate;

    //需要指定商品唯一标识，商品数量以及所在门店；返回指定门店的商品现存数量。出库ledger.num<0 入库ledger.num>0

    @Transactional
    public Stock insertLedger(Ledger ledger) {
        Stock byStock = stockService.getByStock(ledger.getStock());
        if(byStock==null){
            if(ledger.getNum()<0)return null;
            int insert = this.getBaseMapper().insert(ledger);
            stockService.save(ledger.getStock().setStockNum(ledger.getNum()));
            return stockService.getById(ledger.getStock().getId());
        }else {

            int num = ledger.getNum() + byStock.getStockNum();
            if(num<0) return null;
//            出库入库台账
            this.getBaseMapper().insert(ledger);
//            改库存
            stockService.updateById(byStock.setStockNum(num));
            if(ledger.getNum()<0){
//            发消息给admin

                messageService.save(new Message().setLedgerId(ledger.getId()).setStatus(0).setToId(1).setCreateTime(new Timestamp(new Date().getTime())));
            }
            return stockService.getById(byStock.getId());
        }
    }

    public Page<Ledger> getLog(Page<Ledger> page, String name, Timestamp date) {
        Product product = productService.getBaseMapper().selectOne(new QueryWrapper<Product>().eq("name", name));
        return this.getBaseMapper().selectPage(page, new QueryWrapper<Ledger>().eq("product_id", product.getId()).gt("create_time", date));
    }

    public CountPoduct getCountProduct(CountPoduct countPoduct) {
        List<Stock> productId = stockService.getBaseMapper().selectList(new QueryWrapper<Stock>().eq("product_id", countPoduct.getProduct().getId()));
        Long count= 0L;
        BigDecimal countValue=new BigDecimal(0);
        Map<Integer,BigDecimal> skuIds=new ConcurrentHashMap<>();
        for (Stock stock : productId) {
            skuIds.putIfAbsent(stock.getSkuId(),skuService.getById(stock.getSkuId()).getPrice());
        }
        for (Stock stock:productId){
            count+=stock.getStockNum();
            BigDecimal bigDecimal = new BigDecimal(stock.getStockNum());
            countValue=skuIds.get(stock.getSkuId()).multiply(bigDecimal).add(countValue);
        }
        return countPoduct.setCountStock(count).setCountValue(countValue);
    }


}

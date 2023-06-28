package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.Stock;
import com.hubu.gl.dao.mapper.StockMapper;
import com.hubu.gl.service.IStockService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 上午12:17
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {
    public Stock getByStock(Stock stock) {
        return this.getBaseMapper().selectOne(new QueryWrapper<Stock>().eq("product_id",stock.getProductId())
                .eq("sku_id",stock.getSkuId()).eq("store_id",stock.getStoreId()));
    }

    public List<Stock> getAllSku(Stock stock) {
        return this.getBaseMapper().selectList(new QueryWrapper<Stock>().eq("product_id", stock.getProductId()).eq("store_id", stock.getStoreId()));
    }


}

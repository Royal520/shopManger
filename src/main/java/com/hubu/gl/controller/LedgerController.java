package com.hubu.gl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hubu.gl.Entity.Ledger;
import com.hubu.gl.Entity.Product;
import com.hubu.gl.Entity.Stock;
import com.hubu.gl.Entity.rep.CountPoduct;
import com.hubu.gl.Entity.rep.R;
import com.hubu.gl.service.ILedgerService;
import com.hubu.gl.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * @author Lovejj
 * @version 1.0
 * @description: 出库入库查询库存
 * @date 2023/6/28 下午12:49
 */
@RestController
@RequestMapping("/stock")
public class LedgerController {

    @Autowired
    ILedgerService ledgerService;

    @Autowired
    IProductService productService;

    @PostMapping("/inc")
    public int incStock(@RequestBody Ledger ledger){
        Stock stock = ledgerService.insertLedger(ledger);
        return stock==null?0:stock.getStockNum();
    }

    @PostMapping("/dec")
    public int decStock(@RequestBody Ledger ledger){
        Stock stock = ledgerService.insertLedger(ledger);
        return stock==null?0:stock.getStockNum();
    }

    @PostMapping("/log")
    public R<Ledger> getLog(int page, int size, Timestamp timestamp,String name){
        Page<Ledger> log = ledgerService.getLog(Page.of(page, size), name, timestamp);
        return new R<>(log);
    }

    @PostMapping("/countProduct")
    public CountPoduct CountByProductId(@RequestParam int id){
        Product byId = productService.getById(id);
        return ledgerService.getCountProduct(new CountPoduct().setProduct(byId));
    }




}

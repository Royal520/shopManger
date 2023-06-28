package com.hubu.gl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hubu.gl.Entity.Stock;

import java.sql.Timestamp;
import java.util.List;

public interface IStockService extends IService<Stock> {
    public Stock getByStock(Stock stock);

    public List<Stock> getAllSku(Stock stock);

}

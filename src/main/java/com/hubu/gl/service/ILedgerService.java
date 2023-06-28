package com.hubu.gl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hubu.gl.Entity.Ledger;
import com.hubu.gl.Entity.Stock;
import com.hubu.gl.Entity.rep.CountPoduct;

import java.sql.Date;
import java.sql.Timestamp;

public interface ILedgerService extends IService<Ledger> {
    public Stock insertLedger(Ledger ledger);

    public Page<Ledger> getLog(Page<Ledger> page, String name, Timestamp date);

    public CountPoduct getCountProduct(CountPoduct countPoduct);
}

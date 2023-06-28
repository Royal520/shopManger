package com.hubu.gl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hubu.gl.Entity.Ledger;
import com.hubu.gl.Entity.Message;

import java.sql.Timestamp;

public interface IMessageService extends IService<Message> {

    public Page<Message> getByTime(Page<Message> page, Timestamp start,boolean direction);

    public Page<Message> getAll(Page<Message> page,int userId);
}

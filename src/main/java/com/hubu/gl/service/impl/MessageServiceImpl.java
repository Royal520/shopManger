package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.Message;
import com.hubu.gl.dao.mapper.MessageMapper;
import com.hubu.gl.service.IMessageService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author Lovejj
 * @version 1.0
 * @description: 消息模块
 * @date 2023/6/28 下午2:27
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
    public Page<Message> getByTime(Page<Message> page, Timestamp start, boolean direction) {
        if(direction){
            return this.getBaseMapper().selectPage(page, new QueryWrapper<Message>().ge("create_time", start));
        }
        return this.getBaseMapper().selectPage(page, new QueryWrapper<Message>().le("create_time", start));
    }

    public Page<Message> getAll(Page<Message> page,int userId) {
        return this.getBaseMapper().selectPage(page,new QueryWrapper<Message>().eq("user_id",userId));
    }
}

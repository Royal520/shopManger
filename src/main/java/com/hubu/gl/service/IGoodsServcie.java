package com.hubu.gl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hubu.gl.Entity.Goods;
import com.hubu.gl.Entity.QueryCondition;

import java.util.List;

public interface IGoodsServcie extends IService<Goods> {
    public List<Goods> selectByCondition(QueryCondition condition);
}

package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.*;
import com.hubu.gl.dao.mapper.GoodsMapper;
import com.hubu.gl.service.IGoodsServcie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/14 下午3:15
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsServcie {

    public List<Goods> selectByCondition(QueryCondition condition) {
        return this.getBaseMapper()
                .selectList(parse(condition.getRules(),condition.getCondition(), new QueryWrapper<>()));
    }

    public QueryWrapper<Goods> parse(List<Rule> rules,Condition condition,QueryWrapper<Goods> goodsWrapper){
        if (condition.equals(Condition.OR)) {
            for (Rule rule : rules) {
                if (rule.getRules()==null) {
                    goodsWrapper.or(wrapper -> consumerWrapper(wrapper, rule));
                } else {
                    goodsWrapper.or(wrapper -> parse(rule.getRules(), rule.getCondition(), wrapper));
                }
            }
        } else {
            for (Rule rule : rules) {
                if (rule.getRules()==null) {
                    goodsWrapper.and(wrapper -> consumerWrapper(wrapper, rule));
                } else {
                    goodsWrapper.and(wrapper -> parse(rule.getRules(), rule.getCondition(), wrapper));
                }
            }
        }
        return goodsWrapper;

    }

    public void consumerWrapper(QueryWrapper<Goods> tempWrapper, Rule rule) {
            RuleOperator operator =  rule.getOperator();
            switch (operator){
                case EQUAL:{
                    tempWrapper=tempWrapper.eq(rule.getField(),rule.getValue());
                    break;
                }
                case LIKE:{
                    tempWrapper=tempWrapper.like(rule.getField(),rule.getValue());
                    break;
                }
                case GREATER:{
                    tempWrapper=tempWrapper.gt(rule.getField(),rule.getValue());
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
    }

}

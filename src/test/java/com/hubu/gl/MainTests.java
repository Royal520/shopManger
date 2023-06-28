package com.hubu.gl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hubu.gl.Entity.*;
import com.hubu.gl.dao.mapper.GoodsMapper;
import com.hubu.gl.service.IGoodsServcie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/14 下午9:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    IGoodsServcie goodsServcie;
    @Test
    public void testMapper(){
        QueryWrapper<Goods> or = new QueryWrapper<Goods>().or(i->i.like("names","gl").gt("re_date","2023-06-13").eq("inventory",11)).or(i -> i.eq("id", 1));
        QueryCondition queryCondition = new QueryCondition();
        List<Rule> rules=new ArrayList<>();
        Rule rule = new Rule();
        rule.setOperator(RuleOperator.EQUAL).setValue("'1') or ('1=1'").setField("id");
        List<Rule> list=new ArrayList<>();
        list.add(new Rule().setCondition(Condition.AND).setField("names").setOperator(RuleOperator.LIKE).setValue("gl"));
        list.add(new Rule().setCondition(Condition.AND).setField("inventory").setOperator(RuleOperator.EQUAL).setValue("11"));
        list.add(new Rule().setCondition(Condition.AND).setOperator(RuleOperator.GREATER).setValue("2023-06-13").setField("re_date"));
        Rule rule1 = new Rule().setCondition(Condition.AND).setRules(list);
        rules.add(rule);
        rules.add(rule1);
        queryCondition.setCondition(Condition.OR).setValid(Boolean.TRUE).setRules(rules);
        goodsServcie.selectByCondition(queryCondition);
//        System.out.println(goodsMapper.selectList(or));
    }
}

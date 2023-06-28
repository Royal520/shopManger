package com.hubu.gl.Entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/14 下午3:23
 */
@Data
@ToString
@Accessors(chain = true)
public class Rule {
    public String id;
    public String field;
    public String type;
    public String input;
    public RuleOperator operator;
    public String Value;
    public Condition condition;
    public List<Rule> rules;
}

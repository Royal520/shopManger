package com.hubu.gl.Entity;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/14 下午3:23
 */
public class Rule {
    public String id;
    public String field;
    public String type;
    public String input;
    public Enum<RuleOperator> operator;
    public String Value;
    public Enum<Condition> condition;
}

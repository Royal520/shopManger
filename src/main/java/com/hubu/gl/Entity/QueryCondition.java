package com.hubu.gl.Entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/14 下午3:18
 */
@Data
@ToString
@Accessors(chain = true)
public class QueryCondition {
    public Condition condition;
    public boolean valid;
    public List<Rule> rules;

}

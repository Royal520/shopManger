package com.hubu.gl.Entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.awt.datatransfer.FlavorEvent;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/14 下午3:07
 */
@Data
@ToString
@Accessors(chain = true)
public class Goods {
    public Integer id;
    public String names;
    public Float price;
    public String description;
    public String reDate;

    public Integer inventory;
}

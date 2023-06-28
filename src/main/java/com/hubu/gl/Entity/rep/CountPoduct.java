package com.hubu.gl.Entity.rep;

import com.hubu.gl.Entity.Product;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 下午1:48
 */
@Data
@ToString
@Accessors(chain = true)
public class CountPoduct {
    private Product product;
    private Long countStock;
    private BigDecimal countValue;
}

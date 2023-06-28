package com.hubu.gl.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class ProductSku implements Serializable {
    /**
     *
     */
    @TableId(type= IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private Integer productId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String img;

    /**
     *
     */
    private BigDecimal price;
    @TableLogic(value = "0",delval = "-1")
    private Integer status;

    private static final long serialVersionUID = 1L;
}


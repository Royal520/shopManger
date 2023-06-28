package com.hubu.gl.Entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Stock implements Serializable {

    @TableId(type= IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 规格id
     */
    private Integer skuId;

    /**
     * 仓库id
     */
    private Integer storeId;

    /**
     * 库存
     */
    private Integer stockNum;


    private static final long serialVersionUID = 1L;
}


package com.hubu.gl.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
@Accessors(chain = true)
public class Product implements Serializable {
    /**
     *
     */
    @TableId(type= IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String name;

    /**
     *
     */
    private BigDecimal minimumPrice;

    /**
     *
     */
    private BigDecimal maximumPrice;

    /**
     *
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    /**
     *
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;

    /**
     *
     */
    private Integer sort;

    /**
     *
     */
    private String intro;

    /**
     * 状态 -1=>下架,1=>上架,2=>预售,0=>未上架
     */
    @TableLogic(value = "0",delval = "-1")
    private Integer status;

    private static final long serialVersionUID = 1L;

    @TableField(exist=false)
    private List<ProductSku> skuList;
}


package com.hubu.gl.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
@Accessors(chain = true)
public class Ledger implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private Integer productId;

    /**
     *
     */
    private Integer skuId;

    /**
     *
     */
    private Integer storeId;

    /**
     *
     */
    private Integer num;

    /**
     *
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;


    private static final long serialVersionUID = 1L;

    public Stock getStock(){
        return new Stock().setProductId(this.getProductId()).setStoreId(this.getStoreId()).setSkuId(this.getSkuId());
    }
}


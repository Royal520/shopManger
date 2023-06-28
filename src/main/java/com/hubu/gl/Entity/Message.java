package com.hubu.gl.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Message implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String text;

    /**
     *
     */
    private Timestamp createTime;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private Integer toId;

    /**
     *
     */
    private Timestamp readTime;
    private Integer ledgerId;

    @TableField(exist = false)
    private Ledger ledger;

    private static final long serialVersionUID = 1L;
}


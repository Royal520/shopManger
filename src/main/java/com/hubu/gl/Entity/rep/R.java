package com.hubu.gl.Entity.rep;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/27 下午5:18
 */
@Data
@ToString
@Accessors
public class R <T>{
    private long current;
    private long size;
    private long total;
    private List<T> data;
    public R(IPage<T> page){
        this.current=page.getCurrent();
        this.size=page.getSize();
        this.total=page.getTotal();
        this.data=page.getRecords();
    }
}

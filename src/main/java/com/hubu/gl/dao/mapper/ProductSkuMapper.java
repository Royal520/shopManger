package com.hubu.gl.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hubu.gl.Entity.ProductSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductSkuMapper extends BaseMapper<ProductSku> {

    @Update("update product_sku set status=-1 where product_id={#id}}")
    public boolean softDelete(Integer id);
}

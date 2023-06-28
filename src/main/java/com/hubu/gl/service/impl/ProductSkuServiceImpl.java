package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.ProductSku;
import com.hubu.gl.dao.mapper.ProductSkuMapper;
import com.hubu.gl.service.IProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/27 下午5:26
 */
@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuMapper, ProductSku> implements IProductSkuService {
    @Autowired
    ProductSkuMapper productSkuMapper;
    public boolean softDelete(Integer id) {
        return productSkuMapper.softDelete(id);
    }
}

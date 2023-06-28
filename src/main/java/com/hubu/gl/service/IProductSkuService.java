package com.hubu.gl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hubu.gl.Entity.ProductSku;

public interface IProductSkuService extends IService<ProductSku> {

    public boolean softDelete(Integer id);
}

package com.hubu.gl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hubu.gl.Entity.Product;
import com.hubu.gl.Entity.rep.R;

public interface IProductService extends IService<Product> {
    public R<Product> getPage(Page<Product> page,String name);

    public boolean softDelete(Integer id);
}

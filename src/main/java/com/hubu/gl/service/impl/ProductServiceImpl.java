package com.hubu.gl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hubu.gl.Entity.Product;
import com.hubu.gl.Entity.ProductSku;
import com.hubu.gl.Entity.rep.R;
import com.hubu.gl.dao.mapper.ProductMapper;
import com.hubu.gl.dao.mapper.ProductSkuMapper;
import com.hubu.gl.service.IProductService;
import com.hubu.gl.service.IProductSkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/27 下午5:25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    IProductSkuService skuService;

    public void insert(Product product){
        this.getBaseMapper().insert(product);
    }

    public R<Product> getPage(Page<Product> page,String name) {
        Page<Product> productPage=new Page<Product>();
        if(StringUtils.isBlank(name)){
            productPage = this.getBaseMapper().selectPage(page, null);
        }else {
            productPage = this.getBaseMapper().selectPage(page, new QueryWrapper<Product>().like("name",name));
        }
        List<Product> records = productPage.getRecords();
        for (Product product: records){
            List<ProductSku> skuList = skuService.list(new QueryWrapper<ProductSku>().eq("product_id", product.getId()));
            product.setSkuList(skuList);
        }
        return new R<Product>(productPage);

    }

    @Transactional
    public boolean softDelete(Integer id) {
        boolean product=this.removeById(id);
        boolean sku = skuService.softDelete(id);
        return sku&&product;
    }
}

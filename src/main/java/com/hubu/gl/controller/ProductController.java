package com.hubu.gl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hubu.gl.Entity.Product;
import com.hubu.gl.Entity.ProductSku;
import com.hubu.gl.Entity.rep.R;
import com.hubu.gl.service.IProductService;
import com.hubu.gl.service.IProductSkuService;
import com.hubu.gl.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lovejj
 * @version 1.0
 * @description: TODO
 * @date 2023/6/27 下午5:30
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    IProductService productService;
    IProductSkuService skuService;

    @Autowired
    ProductController(IProductService productService, IProductSkuService productSkuService){
        this.productService=productService;
        this.skuService=productSkuService;
    }

    @PostMapping("/insert")
    public ResponseResult insert(@RequestBody Product product){
        boolean save = productService.save(product);
        return save?ResponseResult.SUCCESS():ResponseResult.FAIL();
    }

    @PostMapping("insertSku")
    public ResponseResult insertSku(@RequestBody ProductSku sku){
        boolean save = skuService.save(sku);
        return save?ResponseResult.SUCCESS():ResponseResult.FAIL();
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody Product product){
        boolean success=productService.updateById(product);
        return success?ResponseResult.SUCCESS():ResponseResult.FAIL();
    }

    @PostMapping("/updateSku")
    public ResponseResult update(@RequestBody ProductSku sku){
        boolean b = skuService.updateById(sku);
        return b?ResponseResult.SUCCESS():ResponseResult.FAIL();
    }

    @PostMapping("/delete")
    public ResponseResult delete(@RequestParam int id){
        boolean b = productService.softDelete(id);
        return b?ResponseResult.SUCCESS():ResponseResult.FAIL();

    }

    @PostMapping("/deleteSku")
    public ResponseResult deleteSku(@RequestParam int id){
        boolean b = skuService.softDelete(id);
        return b?ResponseResult.SUCCESS():ResponseResult.FAIL();
    }
    @PostMapping("/get")
    public R<Product> getProduct(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam(required = false,name = "name") String name){
        return productService.getPage(Page.of(page,size),name);
    }
}

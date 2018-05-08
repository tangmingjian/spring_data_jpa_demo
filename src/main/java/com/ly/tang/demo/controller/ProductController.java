package com.ly.tang.demo.controller;

import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.response.wrapper.PageableWrapper;
import com.ly.tang.demo.response.wrapper.PageableWrapperMapper;
import com.ly.tang.demo.response.wrapper.Wrapper;
import com.ly.tang.demo.response.wrapper.WrapperMapper;
import com.ly.tang.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tangmingjian 2018-04-28 上午10:23
 **/
@Controller
@RequestMapping("api/product")
@ResponseBody
@Api(value = "Product apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Add a product", httpMethod = "POST")
    @PostMapping
    Wrapper<Product> addProcuct(@RequestBody Product product) {
        Long categoryId = product.getProductCategory().getId();
        if (categoryId == null || categoryId <= 0) return WrapperMapper.illegalParams();
        Product added = productService.add(product);
        return WrapperMapper.ok(added);
    }

    @ApiOperation(value = "Delete a product", httpMethod = "DELETE")
    @DeleteMapping(value = "/{id}")
    Wrapper<Product> deleteProduct(@PathVariable("id") Long id) {
        if (id <= 0) return WrapperMapper.illegalParams();
        productService.delete(id);
        return WrapperMapper.ok(null);
    }

    @ApiOperation(value = "Update product", httpMethod = "PUT")
    @PutMapping
    Wrapper<Product> updateProduct(@RequestBody Product product) {
        Long productId = product.getId();
        if (productId == null || productId <= 0) return WrapperMapper.illegalParams();
        Product updated = productService.update(product);
        return WrapperMapper.ok(updated);
    }

    @ApiOperation(value = "Get all products", httpMethod = "GET")
    @GetMapping(value = "all")
    Wrapper<List<Product>> getAllPorducts() {
        List<Product> products = productService.getAll();
        return WrapperMapper.ok(products);
    }

    @ApiOperation(value = "Get a product ", httpMethod = "GET")
    @GetMapping(value = "{id}")
    Wrapper<Product> getById(@PathVariable("id") Long id) {
        if (id <= 0) return WrapperMapper.illegalParams();
        Product product = productService.getById(id);
        return WrapperMapper.ok(product);
    }

    @ApiOperation(value = "Get all products pageable", httpMethod = "GET")
    @GetMapping(value = "pageable")
    PageableWrapper<List<Product>> getAllPorductsPageable(@RequestParam(value = "page", defaultValue = "0") int currPage, @RequestParam(value = "size", defaultValue = "10") int size) {
        if (currPage < 0 || size <= 0) return PageableWrapperMapper.illegalParams();
        return productService.getProductsPageable(currPage, size);
    }

    @ApiOperation(value = "Get all products by params", httpMethod = "GET")
    @GetMapping
    Wrapper<List<Product>> getAllPorductsByParams(Product params) {
        List<Product> products = productService.getAllByParams(params);
        return WrapperMapper.ok(products);
    }
}

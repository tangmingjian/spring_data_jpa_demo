package com.ly.tang.demo.service.impl;

import com.ly.tang.demo.dao.BaseTest;
import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.response.wrapper.PageableWrapper;
import com.ly.tang.demo.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.List;

@EnableAutoConfiguration
public class ProductServiceImplTest extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    public void add() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        List<Product> all = productService.getAll();
        System.out.println(all);
    }

    @Test
    public void getById() throws Exception {
        Product product = productService.getById(10000l);
        System.out.println(product);
    }

    @Test
    public void getProductsPageable() throws Exception {
        Product params = new Product();
        params.setStatus(1);
        PageableWrapper<List<Product>> productsPageable = productService.getProductsPageable(params,1, 2);
        System.out.println(productsPageable);

    }

    @Test
    public void getAllPyParams() throws Exception {
    }
}
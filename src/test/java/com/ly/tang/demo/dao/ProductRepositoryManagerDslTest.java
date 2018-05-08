package com.ly.tang.demo.dao;

import com.ly.tang.demo.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static org.junit.Assert.*;

@EnableAutoConfiguration
public class ProductRepositoryManagerDslTest extends BaseTest{

    @Autowired
    private ProductRepositoryManagerDsl productRepositoryManagerDsl;

    @Test
    public void testGetByName(){
        Product iphone = productRepositoryManagerDsl.getByName("iphone");
        System.out.println(iphone);
    }

}
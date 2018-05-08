package com.ly.tang.demo.dao;

import com.ly.tang.demo.domain.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.CollectionUtils;

import java.util.List;
@EnableAutoConfiguration
public class ProductCategoryDaoTest extends BaseTest{
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testFindAll(){
        List<ProductCategory> all = productCategoryDao.findAll();
        assert !CollectionUtils.isEmpty(all);
        System.out.println(all);
    }
}
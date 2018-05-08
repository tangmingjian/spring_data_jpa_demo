package com.ly.tang.demo.dao;

import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.domain.ProductCategory;
import com.ly.tang.demo.domain.ProductNameOnly;
import com.ly.tang.demo.domain.ProductOnly;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;
import java.util.List;

@EnableAutoConfiguration
public class ProductDaoTest extends BaseTest{
    String name = "Apple iPhone 7 Plus (A1661) 128G  4G";
    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindAll() {
        List<Product> all = productDao.findAll();
        assert all.size() > 0;
        System.out.println(all);
    }

    @Test
    public void testQueryByName() {
//        Product product = productDao.queryByName(name);
//        assert product != null;
//        System.out.println(product);
//        System.out.println("-------------------");
//        List<ProductOnly> products = productDao.queryByName(name, ProductOnly.class);
//        System.out.println(products);
//        System.out.println("-------------------");

        List<ProductNameOnly> names = productDao.queryByName(name, ProductNameOnly.class);
        System.out.println(names);
    }

    @Test
    public void testFindByName() {
        Product product = productDao.findByName(name);
        assert product != null;
        System.out.println(product);
    }

    @Test
    public void testFindProductById() {
        Product product = productDao.findProductById(26);
        assert product != null;

        System.out.println(product);
    }

    @Test
    public void testFindById() {
        Product product = productDao.findById(26);
        assert product != null;
        System.out.println(product);
    }

    @Test
    public void testFindByNameAndAndProductCode() {
        Product product = productDao.findByNameAndAndProductCode(name, "26");
        assert product != null;
        System.out.println(product);

    }

    @Test
    public void testSave() {
        Product product = new Product();
        product.setId(100000l);
        product.setName("水杯");
        product.setPrice(new BigDecimal("8000.00"));
        product.setStock(10);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(100001l);
        product.setProductCategory(productCategory);
        product.setProductCode("26");
        product.setVersion("1.0");
        Product saved = productDao.save(product);

        assert saved != null;
        System.out.println(saved);
    }
    @Test
    public void testQueryByPriceBetween(){
        List<Product> products = productDao.queryByPriceBetween(BigDecimal.ONE, BigDecimal.valueOf(10000));
        System.out.println(products);
    }

    @Test
    public void testGetNameOnly(){
        ProductNameOnly nameOnly = productDao.getNameOnly(312415946738247680l);
        System.out.println(nameOnly);
    }
}
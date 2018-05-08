package com.ly.tang.demo.dao;

import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.domain.ProductNameOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author tangmingjian 2018-04-27 下午4:07
 **/
public interface ProductDao extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> ,JpaSpecificationExecutor<Product> {

    Product queryByName(String name);

    Product findByName(String name);

    Product findProductById(long id);

    Product findByNameAndAndProductCode(String name, String productCode);

    List<Product> queryByPriceBetween(BigDecimal start,BigDecimal end);

    <T> List<T>  queryByName(String name,Class<T> type);

    @Query(value = "select * from pc_mdc_product where id=?1", nativeQuery = true)
    Product findById(long id);

    @Query(value = "select name from pc_mdc_product where id=?1",nativeQuery = true)
    ProductNameOnly getNameOnly(Long id);
}

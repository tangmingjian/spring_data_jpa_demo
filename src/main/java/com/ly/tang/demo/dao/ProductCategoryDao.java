package com.ly.tang.demo.dao;

import com.ly.tang.demo.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author tangmingjian 2018-04-27 下午11:09
 **/
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Long>, QuerydslPredicateExecutor<ProductCategory> {


}

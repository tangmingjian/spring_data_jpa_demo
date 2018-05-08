package com.ly.tang.demo.dao;

import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.domain.QProduct;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author tangmingjian 2018-05-01 下午12:16
 **/
@Repository
public class ProductRepositoryManagerDsl {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;


    public Product getByName(String name){
        QProduct product = QProduct.product;
        JPAQuery<?> query = new JPAQuery<>(entityManager);
        return query.select(product)
                .from(product)
                .where(product.name.eq(name))
                .fetchOne();
    }

}

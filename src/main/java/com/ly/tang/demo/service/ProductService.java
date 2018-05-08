package com.ly.tang.demo.service;

import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.response.wrapper.PageableWrapper;

import java.util.List;

/**
 * @author tangmingjian 2018-04-28 上午10:06
 **/
public interface ProductService {

    Product add(Product record);

    void delete(Long id);

    Product update(Product record);

    List<Product> getAll();

    Product getById(long id);

    PageableWrapper<List<Product>> getProductsPageable(int page, int size);

    PageableWrapper<List<Product>> getProductsPageable(Product params,int page, int size);

    List<Product> getAllByParams(Product params);
}

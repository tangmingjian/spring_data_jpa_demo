package com.ly.tang.demo.service.impl;

import com.ly.tang.demo.dao.ProductDao;
import com.ly.tang.demo.dao.specifications.ProductSpecification;
import com.ly.tang.demo.domain.Product;
import com.ly.tang.demo.domain.QProduct;
import com.ly.tang.demo.response.wrapper.PageableWrapper;
import com.ly.tang.demo.response.wrapper.PageableWrapperMapper;
import com.ly.tang.demo.service.ProductService;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author tangmingjian 2018-04-28 上午10:07
 **/
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product add(Product record) {
        log.info("Save product:{}", record);
        return productDao.saveAndFlush(record);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete product with id:{}",id);
        productDao.deleteById(id);
    }

    @Override
    public Product update(Product record) {
        log.info("Update product:{}", record);
        return productDao.saveAndFlush(record);
    }

    @Override
    public List<Product> getAll() {
        log.info("get all");
        return productDao.findAll();
    }

    @Override
    public Product getById(long id) {
        log.info("get product by id:{}", id);
        QProduct qProduct = QProduct.product;
        Predicate predicate = qProduct.id.eq(id);
        Optional<Product> one = productDao.findOne(predicate);
        return one.orElse(null);
//        return productDao.findById(id);
    }

    @Override
    public PageableWrapper<List<Product>> getProductsPageable(int page, int size) {
        Page<Product> products = productDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTime")));
        List<Product> data = products.getContent();
        int totalSize = ((Long)products.getTotalElements()).intValue();
        return PageableWrapperMapper.ok(data,page,size,totalSize);
    }

    @Override
    public PageableWrapper<List<Product>> getProductsPageable(Product params, int page, int size) {
        ProductSpecification specification = new ProductSpecification(params);
        Page<Product> products = productDao.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTime")));
        int totalSize = ((Long)products.getTotalElements()).intValue();
        return PageableWrapperMapper.ok(products.getContent(),page,size,totalSize);
    }

    @Override
    public List<Product> getAllByParams(Product params){
        Example<Product> example = Example.of(new Product());
        Product probe = example.getProbe();
        BeanUtils.copyProperties(params,probe);
        return productDao.findAll(example);
    }
}

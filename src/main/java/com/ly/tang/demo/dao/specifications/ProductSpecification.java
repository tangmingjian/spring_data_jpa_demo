package com.ly.tang.demo.dao.specifications;

import com.ly.tang.demo.domain.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmingjian 2018-05-08 下午3:47
 **/
public class ProductSpecification implements Specification<Product> {

    private Product product;

    public ProductSpecification(Product product) {
        this.product = product;
    }

    @Nullable
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (product != null) {
            if (product.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id").as(Integer.class), product.getId()));
            }
            if (!StringUtils.isEmpty(product.getName())) {
                predicates.add(criteriaBuilder.equal(root.get("name").as(String.class), product.getName()));
            }
            if(!StringUtils.isEmpty(product.getProductCode())){
                predicates.add(criteriaBuilder.equal(root.get("productCode").as(String.class),product.getProductCode()));
            }
            if(product.getStatus()!=null){
                predicates.add(criteriaBuilder.equal(root.get("status").as(Integer.class),product.getStatus()));
            }

        }
        return query.where(predicates.toArray(new Predicate[0])).getRestriction();
    }
}

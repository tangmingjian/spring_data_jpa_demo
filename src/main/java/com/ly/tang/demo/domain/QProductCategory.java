package com.ly.tang.demo.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QProductCategory is a Querydsl query type for ProductCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductCategory extends EntityPathBase<ProductCategory> {

    private static final long serialVersionUID = 388396922L;

    public static final QProductCategory productCategory = new QProductCategory("productCategory");

    public final StringPath categoryCode = createString("categoryCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgId = createString("imgId");

    public final StringPath name = createString("name");

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final StringPath version = createString("version");

    public QProductCategory(String variable) {
        super(ProductCategory.class, forVariable(variable));
    }

    public QProductCategory(Path<? extends ProductCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCategory(PathMetadata metadata) {
        super(ProductCategory.class, metadata);
    }

}


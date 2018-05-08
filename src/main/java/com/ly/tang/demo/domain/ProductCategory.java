package com.ly.tang.demo.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author tangmingjian 2018-04-27 下午4:39
 **/
@Entity
@Table(name = "pc_mdc_product_category")
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String version;

    private String categoryCode;

    private String imgId;

    private long pid;

    private String name;

}

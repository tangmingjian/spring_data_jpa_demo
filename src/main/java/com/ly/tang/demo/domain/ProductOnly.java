package com.ly.tang.demo.domain;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tangmingjian 2018-04-27 下午4:08
 **/
@Value
public class ProductOnly {
    private Long id;

    private String version;

    private String name;

    private String productCode;

    private String subtitle;

    private BigDecimal price;

    private Integer stock;

    private String mainImage;

    private String subImages;

    private String detail;

    private Integer status;

    private String creator;

    private String creatorId;

    private Date createdTime;

    private String lastOperator;

    private String lastOperatorId;

    private Date updateTime;

}

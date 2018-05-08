package com.ly.tang.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tangmingjian 2018-04-27 下午4:08
 **/
@Entity
@Table(name = "pc_mdc_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    @JsonIgnore
    private String lastOperator;

    @JsonIgnore
    private String lastOperatorId;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @OneToOne
    @JoinColumn(name = "category_id",insertable = true)
    private ProductCategory productCategory;
}

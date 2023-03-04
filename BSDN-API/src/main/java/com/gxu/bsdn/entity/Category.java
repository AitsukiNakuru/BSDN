package com.gxu.bsdn.entity;


import java.io.Serializable;
import lombok.Data;


@Data
public class Category implements Serializable {

    private Long id;


    private String categoryName;


    private String description;

    private static final long serialVersionUID = 1L;
}
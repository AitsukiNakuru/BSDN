package com.gxu.bsdn.entity;


import java.io.Serializable;
import lombok.Data;


@Data
public class Collection implements Serializable {

    private Long id;


    private Long articleId;


    private Long userId;

    private static final long serialVersionUID = 1L;
}
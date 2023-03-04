package com.gxu.bsdn.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Comment implements Serializable {

    private Long id;


    private String content;


    private Long userId;


    private Long articleId;


    private Date createTime;

    private static final long serialVersionUID = 1L;
}
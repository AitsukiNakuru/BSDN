package com.gxu.bsdn.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Article implements Serializable {

    private Long id;


    private String title;


    private Date createTime;


    private Long authorId;


    private Long categoryId;


    private Long viewCount;


    private Long thumbCount;


    private Long collectCount;


    private String content;


    private String contentHtml;

    private static final long serialVersionUID = 1L;
}
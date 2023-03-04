package com.gxu.bsdn.vo;

import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.User;

import lombok.Data;

import java.util.Date;
@Data
public class ArticleWithOther {

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


    private User author;


    private Category category;
}

package com.gxu.bsdn.vo;


import lombok.Data;

import java.util.List;

@Data
public class CategoryWithArticle {

    private Long id;

    private String categoryName;

    private String description;

    private List<ArticleWithOther> articleList;
}

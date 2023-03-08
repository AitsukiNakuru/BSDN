package com.gxu.bsdn.vo;

import lombok.Data;

import java.util.List;
@Data
public class ArticleList {
    private List<ArticleWithOther> articleList;
    private Long articleCount;
}

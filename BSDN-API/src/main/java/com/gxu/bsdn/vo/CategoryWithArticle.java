package com.gxu.bsdn.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryWithArticle {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String categoryName;

    @ApiModelProperty(value="")
    private String description;

    private List<ArticleWithAuthorAndCategory> articleList;
}

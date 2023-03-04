package com.gxu.bsdn.vo;

import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ArticleWithOther {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String title;

    @ApiModelProperty(value="")
    private Date createTime;

    @ApiModelProperty(value="")
    private Long authorId;

    @ApiModelProperty(value="")
    private Long categoryId;

    @ApiModelProperty(value="")
    private Long viewCount;

    @ApiModelProperty(value="")
    private Long thumbCount;

    @ApiModelProperty(value="")
    private Long collectCount;

    @ApiModelProperty(value="")
    private String content;

    @ApiModelProperty(value="")
    private String contentHtml;

    @ApiModelProperty(value="")
    private User author;

    @ApiModelProperty(value="")
    private Category category;
}

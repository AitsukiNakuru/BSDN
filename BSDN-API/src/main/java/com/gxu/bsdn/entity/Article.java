package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="article")
@Data
public class Article implements Serializable {
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

    private static final long serialVersionUID = 1L;
}
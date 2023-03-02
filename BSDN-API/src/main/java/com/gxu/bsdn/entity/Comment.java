package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="`comment`")
@Data
public class Comment implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String content;

    @ApiModelProperty(value="")
    private Long userId;

    @ApiModelProperty(value="")
    private Long articleId;

    @ApiModelProperty(value="")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
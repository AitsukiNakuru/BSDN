package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="thumb")
@Data
public class Thumb implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long articleId;

    @ApiModelProperty(value="")
    private Long userId;

    private static final long serialVersionUID = 1L;
}
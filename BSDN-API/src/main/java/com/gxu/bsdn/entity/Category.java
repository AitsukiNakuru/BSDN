package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="category")
@Data
public class Category implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String categoryName;

    @ApiModelProperty(value="")
    private String description;

    private static final long serialVersionUID = 1L;
}
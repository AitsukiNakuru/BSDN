package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="fan")
@Data
public class Fan implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long authorId;

    @ApiModelProperty(value="")
    private Long fanId;

    private static final long serialVersionUID = 1L;
}
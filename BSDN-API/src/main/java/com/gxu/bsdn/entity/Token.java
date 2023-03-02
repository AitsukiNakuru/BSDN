package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="token")
@Data
public class Token implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String token;

    @ApiModelProperty(value="")
    private Date expire;

    private static final long serialVersionUID = 1L;
}
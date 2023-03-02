package com.gxu.bsdn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="`admin`")
@Data
public class Admin implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String username;

    @ApiModelProperty(value="")
    private String nickname;

    private static final long serialVersionUID = 1L;
}
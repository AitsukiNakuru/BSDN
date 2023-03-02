package com.gxu.bsdn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="`user`")
@Data
public class User implements Serializable {
    @ApiModelProperty(value="", example = "1")
    private Long id;

    @ApiModelProperty(value="", example = "AitsukiNakuru")
    private String username;

    @ApiModelProperty(value="", example = "AitsukiNakuru")
    private String password;

    @ApiModelProperty(value="", example = "AitsukiNakuru")
    private String nickname;

    @ApiModelProperty(value="", example = "AitsukiNakuru")
    private String introduction;

    @ApiModelProperty(value="", example = "AitsukiNakuru")
    private String avatar;

    @ApiModelProperty(value="", example = "AitsukiNakuru")
    private String email;

    @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="", example = "2022-10-20 20:17:57")
    private Date createTime;

    @JsonFormat(timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="", example = "2022-10-20 20:17:57")
    private Date lastLogin;

    private static final long serialVersionUID = 1L;
}
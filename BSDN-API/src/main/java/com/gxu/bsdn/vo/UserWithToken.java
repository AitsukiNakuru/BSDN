package com.gxu.bsdn.vo;


import lombok.Data;

import java.util.Date;
@Data
public class UserWithToken {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String introduction;

    private String avatar;

    private String email;

    private Date createTime;

    private Date lastLogin;

    private String token;

}

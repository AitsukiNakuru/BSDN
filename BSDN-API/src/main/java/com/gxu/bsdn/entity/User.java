package com.gxu.bsdn.entity;



import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class User implements Serializable {

    private Long id;


    private String username;


    private String password;


    private String nickname;


    private String introduction;


    private String avatar;


    private String email;


    private Date createTime;


    private Date lastLogin;

    private static final long serialVersionUID = 1L;
}
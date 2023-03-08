package com.gxu.bsdn.entity;

import lombok.Data;

@Data
public class Admin {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String username;

    private String nickname;

    private String password;
}
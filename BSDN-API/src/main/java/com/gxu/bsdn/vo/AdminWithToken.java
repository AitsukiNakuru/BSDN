package com.gxu.bsdn.vo;

import lombok.Data;

@Data
public class AdminWithToken {
    private Long id;

    private String username;

    private String nickname;

    private String token;
}

package com.gxu.bsdn.vo;

import com.gxu.bsdn.entity.User;

import lombok.Data;

import java.util.Date;
@Data
public class CommentWithUser {

    private Long id;


    private String content;


    private Long userId;


    private Long articleId;


    private Date createTime;

    private User user;
}

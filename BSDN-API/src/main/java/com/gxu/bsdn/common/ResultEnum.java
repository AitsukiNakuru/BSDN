package com.gxu.bsdn.common;

public enum ResultEnum {

    ERROR("错误"),

    SUCCESS("成功"),

    // Common
    UPDATE_SUCCESS("修改成功"),
    UPDATE_FAILURE("修改失败"),
    DELETE_SUCCESS("删除成功"),
    DELETE_FAILURE("删除失败"),
    SELECT_SUCCESS("查询成功"),
    SELECT_FAILURE("查询失败"),
    INSERT_SUCCESS("添加成功"),
    INSERT_FAILURE("添加失败"),

    // User
    LOGIN_SUCCESS("登陆成功"),
    LOGIN_FAILURE("登录失败"),
    REGISTER_SUCCESS("注册成功"),
    REGISTER_FAILURE("注册失败"),
    USERNAME_NOT_EXIST("用户名不存在"),
    USERNAME_EXIST("用户名已存在"),
    USERNAME_DUPLICATE("用户名重复"),
    PASSWORD_ERROR("密码错误"),

    // Article
    PUBLIC_SUCCESS("发布成功"),
    PUBLIC_FAILURE("发布失败"),
    THUMB_SUCCESS("点赞成功"),
    THUMB_FAILURE("点赞失败"),
    COLLECT_SUCCESS("收藏成功"),
    COLLECT_FAILURE("收藏失败"),


    // Category
    CATEGORY_EXIST("分类已存在"),
    CATEGORY_NOT_EXIST("分类不存在"),
    CATEGORY_ARTICLE_EXIST("分类存在文章"),
    CATEGORY_ARTICLE_NOT_EXIST("分类不存在文章"),
    VALIDATION_FAILURE("验证失败"),

    // Fan
    SUBSCRIBE_SUCCESS("订阅成功"),
    SUBSCRIBE_FAILURE("订阅失败"),
    CANCEL_SUBSCRIBE_SUCCESS("取消订阅成功"),
    CANCEL_SUBSCRIBE_FAILURE("取消订阅失败");




    private String result;

    ResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

package com.gxu.bsdn.entity;



import java.io.Serializable;
import lombok.Data;


@Data
public class Admin implements Serializable {

    private Long id;


    private String username;


    private String nickname;

    private static final long serialVersionUID = 1L;
}
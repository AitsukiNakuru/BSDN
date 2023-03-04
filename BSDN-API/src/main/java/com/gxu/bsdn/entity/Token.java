package com.gxu.bsdn.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Token implements Serializable {

    private Long id;


    private String token;


    private Date expire;

    private static final long serialVersionUID = 1L;
}
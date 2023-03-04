package com.gxu.bsdn.entity;


import java.io.Serializable;
import lombok.Data;


@Data
public class Fan implements Serializable {

    private Long id;


    private Long authorId;


    private Long fanId;

    private static final long serialVersionUID = 1L;
}
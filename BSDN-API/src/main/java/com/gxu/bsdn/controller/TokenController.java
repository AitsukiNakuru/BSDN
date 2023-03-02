package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Token;
import com.gxu.bsdn.service.TokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/token")
public class TokenController {

    @Resource
    private TokenService tokenService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Token selectOne(Long id) {
        return tokenService.selectByPrimaryKey(id);
    }

}

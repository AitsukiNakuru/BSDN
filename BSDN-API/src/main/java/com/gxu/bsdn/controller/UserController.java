package com.gxu.bsdn.controller;
import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.entity.User;
import com.gxu.bsdn.service.UserService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import com.gxu.bsdn.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("/selectOne")
    public User selectOne(Long id) {
        return userService.selectByPrimaryKey(id);
    }


    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

}

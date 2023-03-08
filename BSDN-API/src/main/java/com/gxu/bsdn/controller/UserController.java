package com.gxu.bsdn.controller;

import com.github.pagehelper.PageHelper;
import com.gxu.bsdn.entity.User;
import com.gxu.bsdn.service.UserService;
import com.gxu.bsdn.utils.Result;

import com.gxu.bsdn.utils.ResultGenerator;
import com.gxu.bsdn.vo.UserList;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


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

    @PostMapping("/userList")
    public Result selectUserList(@RequestBody User user, @RequestParam int pageSize, int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        return ResultGenerator.genSuccessResult(userService.selectUserList(user));
    }

}

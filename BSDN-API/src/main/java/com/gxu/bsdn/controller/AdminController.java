package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Admin;
import com.gxu.bsdn.service.AdminService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import com.gxu.bsdn.utils.TokenUtils;
import com.gxu.bsdn.vo.AdminWithToken;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Admin selectOne(Long id) {
        return adminService.selectByPrimaryKey(id);
    }

    @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin admin) {
        String loginResult = adminService.login(admin);
        if (TokenUtils.verify(loginResult)) {
            AdminWithToken adminWithToken = new AdminWithToken();
            BeanUtils.copyProperties(admin, adminWithToken);
            adminWithToken.setToken(loginResult);
            return ResultGenerator.genSuccessResult(adminWithToken);
        } else {
            return ResultGenerator.genFailResult(loginResult);
        }
    }


}

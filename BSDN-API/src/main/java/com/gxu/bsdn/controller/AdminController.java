package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Admin;
import com.gxu.bsdn.service.AdminService;
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

}

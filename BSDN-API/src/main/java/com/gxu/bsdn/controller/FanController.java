package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Fan;
import com.gxu.bsdn.service.FanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/fan")
public class FanController {

    @Resource
    private FanService fanService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Fan selectOne(Long id) {
        return fanService.selectByPrimaryKey(id);
    }

}

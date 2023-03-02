package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Thumb;
import com.gxu.bsdn.service.ThumbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/thumb")
public class ThumbController {

    @Resource
    private ThumbService thumbService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Thumb selectOne(Long id) {
        return thumbService.selectByPrimaryKey(id);
    }

}

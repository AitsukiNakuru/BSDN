package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Comment;
import com.gxu.bsdn.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Comment selectOne(Long id) {
        return commentService.selectByPrimaryKey(id);
    }

}

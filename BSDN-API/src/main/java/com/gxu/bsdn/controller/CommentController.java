package com.gxu.bsdn.controller;
import com.github.pagehelper.PageHelper;
import com.gxu.bsdn.entity.Comment;
import com.gxu.bsdn.service.CommentService;
import com.gxu.bsdn.utils.Result;
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

    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PostMapping("/selectByParam")
    public Result selectByParam(@RequestBody Comment comment, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        return commentService.selectCommentByParam(comment);
    }
}

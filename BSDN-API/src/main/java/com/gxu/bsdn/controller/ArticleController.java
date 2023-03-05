package com.gxu.bsdn.controller;

import com.github.pagehelper.PageHelper;
import com.gxu.bsdn.entity.Article;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.param.ArticleParam;
import com.gxu.bsdn.service.ArticleService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Article selectOne(Long id) {
        return articleService.selectByPrimaryKey(id);
    }

    @PostMapping("/public")
    public Result publicArticle(@RequestBody Article article) {
        return articleService.publicArticle(article);
    }

    @PostMapping("/selectById")
    public Result selectById(@RequestParam("articleId") Long articleId) {
        return articleService.selectById(articleId);
    }

    @PostMapping("/selectByParam")
    public Result selectByParam(@RequestBody ArticleParam articleParam, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        return articleService.selectByParam(articleParam);
    }

    @PostMapping("/selectByCategoryName")
    public Result selectByCategory(@RequestBody Category category) {
        return articleService.selectByCategoryName(category);
    }

    @PostMapping("/update")
    public Result updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

    @PostMapping("/viewArticle")
    public Result viewArticle(@RequestParam Long articleId) {
        return articleService.view(articleId);
    }

    @PostMapping("/deleteArticle")
    public Result deleteArticle(@RequestParam Long articleId) {
        return articleService.deleteArticle(articleId);
    }

    @PostMapping("/selectByAuthorId")
    public Result selectByAuthorId(@RequestParam("authorId") Long authorId, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        return articleService.selectByAuthorId(authorId);
    }
}

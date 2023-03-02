package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Article;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.param.ArticleParam;
import com.gxu.bsdn.service.ArticleService;
import com.gxu.bsdn.utils.Result;
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
    @PostMapping("/selectByParam")
    public Result selectByParam(@RequestBody ArticleParam articleParam) {
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
}

package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.service.CategoryService;
import com.gxu.bsdn.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Category selectOne(Long id) {
        return categoryService.selectByPrimaryKey(id);
    }

    @PostMapping("/add")
    public Result addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("/delete")
    public Result deleteCategory(@RequestBody Category category) {
        return categoryService.deleteCategory(category);
    }

    @PostMapping("/select")
    public Result selectCategory(@RequestBody Category category) {
        return categoryService.selectByCategoryName(category);
    }

    @PostMapping("/update")
    public Result updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }
}

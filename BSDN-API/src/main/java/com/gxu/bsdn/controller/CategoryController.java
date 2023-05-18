package com.gxu.bsdn.controller;
import com.github.pagehelper.PageHelper;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.service.CategoryService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import com.gxu.bsdn.vo.CategoryList;
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

    @PostMapping("/list")
    public Result selectCategoryList(@RequestBody Category category, @RequestParam int pageSize, @RequestParam int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        CategoryList categoryList = categoryService.selectCategoryList(category);
        return ResultGenerator.genSuccessResult(categoryList);
    }

    @PostMapping("/selectAll")
    public Result selectAll() {
        return ResultGenerator.genSuccessResult(categoryService.selectCategoryList(new Category()));
    }
}

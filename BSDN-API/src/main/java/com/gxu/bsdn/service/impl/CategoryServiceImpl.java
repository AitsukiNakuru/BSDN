package com.gxu.bsdn.service.impl;

import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.dao.ArticleMapper;
import com.gxu.bsdn.entity.Article;
import com.gxu.bsdn.entity.User;
import com.gxu.bsdn.entity.example.UserExample;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import com.gxu.bsdn.vo.ArticleWithAuthorAndCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.gxu.bsdn.dao.CategoryMapper;

import java.util.List;

import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.example.CategoryExample;
import com.gxu.bsdn.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public long countByExample(CategoryExample example) {
        return categoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CategoryExample example) {
        return categoryMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public List<Category> selectByExample(CategoryExample example) {
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Category record, CategoryExample example) {
        return categoryMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Category record, CategoryExample example) {
        return categoryMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Category> list) {
        return categoryMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Category> list) {
        return categoryMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Category> list) {
        return categoryMapper.batchInsert(list);
    }

    @Override
    public Result addCategory(Category category) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryNameEqualTo(category.getCategoryName());
        List<Category> categoryList = categoryMapper.selectByExample(example);
        if (categoryList.isEmpty() && categoryMapper.insertSelective(category) == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.INSERT_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.INSERT_FAILURE.getResult());
        }
    }

    @Override
    public Result deleteCategory(Category category) {
        List<ArticleWithAuthorAndCategory> articleList = articleMapper.selectByCategoryId(category);

        if (articleList.isEmpty() && categoryMapper.deleteByPrimaryKey(category.getId()) == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.DELETE_SUCCESS.getResult());
        } else if (!articleList.isEmpty()) {
            return ResultGenerator.genFailResult(ResultEnum.DELETE_FAILURE.getResult() + "，" + ResultEnum.CATEGORY_ARTICLE_EXIST.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.DELETE_FAILURE.getResult());
        }
    }

    @Override
    public Result selectByCategoryName(Category category) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryNameLike(category.getCategoryName());
        List<Category> categoryList = categoryMapper.selectByExample(example);
        return ResultGenerator.genSuccessResult(categoryList);
    }

    @Override
    public Result updateCategory(Category category) {
        Category categoryResult = categoryMapper.selectByPrimaryKey(category.getId());
        if (categoryResult != null && categoryMapper.updateByPrimaryKeySelective(category) == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.UPDATE_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.UPDATE_FAILURE.getResult());
        }
    }
}

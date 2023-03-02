package com.gxu.bsdn.service;

import java.util.List;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.example.CategoryExample;
import com.gxu.bsdn.utils.Result;

public interface CategoryService{


    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Long id);

    int updateByExampleSelective(Category record,CategoryExample example);

    int updateByExample(Category record,CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int updateBatch(List<Category> list);

    int updateBatchSelective(List<Category> list);

    int batchInsert(List<Category> list);

    Result addCategory(Category category);

    Result deleteCategory(Category category);

    Result selectByCategoryName(Category category);

    Result updateCategory(Category category);

}

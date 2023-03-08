package com.gxu.bsdn.vo;

import com.gxu.bsdn.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryList {
    private List<Category> categoryList;
    private Long categoryCount;
}

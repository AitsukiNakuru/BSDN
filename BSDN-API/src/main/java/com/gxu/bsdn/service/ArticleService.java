package com.gxu.bsdn.service;

import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.example.ArticleExample;
import com.gxu.bsdn.entity.Article;
import com.gxu.bsdn.param.ArticleParam;
import com.gxu.bsdn.utils.Result;

import java.util.List;
public interface ArticleService{


    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(Article record,ArticleExample example);

    int updateByExample(Article record,ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    int updateBatch(List<Article> list);

    int updateBatchSelective(List<Article> list);

    int batchInsert(List<Article> list);

    Result publicArticle(Article article);
    Result view(Article article);
    Result thumbArticle(Article article);
    Result collectArticle(Article article);
    Result updateArticle(Article article);
    Result deleteArticle(Article article);
    Result selectArticle(Article article);

    Result selectByParam(ArticleParam articleParam);
    Result selectByCategoryName(Category category);
}
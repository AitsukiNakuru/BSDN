package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Article;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.example.ArticleExample;
import java.util.List;

import com.gxu.bsdn.param.ArticleParam;
import com.gxu.bsdn.vo.ArticleWithOther;
import com.gxu.bsdn.vo.CategoryWithArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Article record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Article record);

    int updateBatch(List<Article> list);

    int updateBatchSelective(List<Article> list);

    int batchInsert(@Param("list") List<Article> list);

    List<ArticleWithOther> selectByParam(ArticleParam articleParam);

    List<CategoryWithArticle> selectByCategoryName(Category category);

    List<ArticleWithOther> selectByCategoryId(Category category);



    ArticleWithOther selectById(Long articleId);

    int thumbArticle(Long articleId);
    int viewArticle(Long articleId);
    int collectArticle(Long articleId);


}
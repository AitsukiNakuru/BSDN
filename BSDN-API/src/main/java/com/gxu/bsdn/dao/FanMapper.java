package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Fan;
import com.gxu.bsdn.entity.example.FanExample;
import java.util.List;

import com.gxu.bsdn.vo.ArticleWithOther;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FanMapper {
    long countByExample(FanExample example);

    int deleteByExample(FanExample example);

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
    int insert(Fan record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Fan record);

    List<Fan> selectByExample(FanExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Fan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Fan record, @Param("example") FanExample example);

    int updateByExample(@Param("record") Fan record, @Param("example") FanExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Fan record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Fan record);

    int updateBatch(List<Fan> list);

    int updateBatchSelective(List<Fan> list);

    int batchInsert(@Param("list") List<Fan> list);

    List<ArticleWithOther> selectSubscribeArticle(Long userId);

    int getFanCount(Long authorId);
}
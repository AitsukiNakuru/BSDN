package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Thumb;
import com.gxu.bsdn.entity.example.ThumbExample;
import java.util.List;

import com.gxu.bsdn.utils.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ThumbMapper {
    long countByExample(ThumbExample example);

    int deleteByExample(ThumbExample example);

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
    int insert(Thumb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Thumb record);

    List<Thumb> selectByExample(ThumbExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Thumb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Thumb record, @Param("example") ThumbExample example);

    int updateByExample(@Param("record") Thumb record, @Param("example") ThumbExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Thumb record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Thumb record);

    int updateBatch(List<Thumb> list);

    int updateBatchSelective(List<Thumb> list);

    int batchInsert(@Param("list") List<Thumb> list);

    int getThumbCount(Long articleId);
}
package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Comment;
import com.gxu.bsdn.entity.example.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

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
    int insert(Comment record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Comment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Comment record);

    int updateBatch(List<Comment> list);

    int updateBatchSelective(List<Comment> list);

    int batchInsert(@Param("list") List<Comment> list);
}
package com.gxu.bsdn.service;

import com.gxu.bsdn.entity.example.CommentExample;
import com.gxu.bsdn.entity.Comment;
import java.util.List;
public interface CommentService{


    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Long id);

    int updateByExampleSelective(Comment record,CommentExample example);

    int updateByExample(Comment record,CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    int updateBatch(List<Comment> list);

    int updateBatchSelective(List<Comment> list);

    int batchInsert(List<Comment> list);

}

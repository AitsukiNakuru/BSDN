package com.gxu.bsdn.service.impl;

import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.bsdn.entity.example.CommentExample;
import com.gxu.bsdn.entity.Comment;
import java.util.List;
import com.gxu.bsdn.dao.CommentMapper;
import com.gxu.bsdn.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Override
    public long countByExample(CommentExample example) {
        return commentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CommentExample example) {
        return commentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public List<Comment> selectByExample(CommentExample example) {
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment selectByPrimaryKey(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Comment record,CommentExample example) {
        return commentMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Comment record,CommentExample example) {
        return commentMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Comment> list) {
        return commentMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Comment> list) {
        return commentMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Comment> list) {
        return commentMapper.batchInsert(list);
    }

    @Override
    public Result addComment(Comment comment) {
        if (commentMapper.insert(comment) == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.INSERT_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.INSERT_FAILURE.getResult());
        }
    }

    @Override
    public Result selectCommentByParam(Comment comment) {

        return ResultGenerator.genSuccessResult(commentMapper.selectByParam(comment));
    }
}

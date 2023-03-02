package com.gxu.bsdn.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.bsdn.dao.ThumbMapper;
import com.gxu.bsdn.entity.Thumb;
import java.util.List;
import com.gxu.bsdn.entity.example.ThumbExample;
import com.gxu.bsdn.service.ThumbService;
@Service
public class ThumbServiceImpl implements ThumbService{

    @Resource
    private ThumbMapper thumbMapper;

    @Override
    public long countByExample(ThumbExample example) {
        return thumbMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ThumbExample example) {
        return thumbMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return thumbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Thumb record) {
        return thumbMapper.insert(record);
    }

    @Override
    public int insertSelective(Thumb record) {
        return thumbMapper.insertSelective(record);
    }

    @Override
    public List<Thumb> selectByExample(ThumbExample example) {
        return thumbMapper.selectByExample(example);
    }

    @Override
    public Thumb selectByPrimaryKey(Long id) {
        return thumbMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Thumb record,ThumbExample example) {
        return thumbMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Thumb record,ThumbExample example) {
        return thumbMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Thumb record) {
        return thumbMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Thumb record) {
        return thumbMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Thumb> list) {
        return thumbMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Thumb> list) {
        return thumbMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Thumb> list) {
        return thumbMapper.batchInsert(list);
    }

}

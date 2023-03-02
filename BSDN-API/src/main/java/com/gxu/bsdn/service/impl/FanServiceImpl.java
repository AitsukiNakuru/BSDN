package com.gxu.bsdn.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxu.bsdn.dao.FanMapper;
import com.gxu.bsdn.entity.example.FanExample;
import com.gxu.bsdn.entity.Fan;
import com.gxu.bsdn.service.FanService;
@Service
public class FanServiceImpl implements FanService{

    @Resource
    private FanMapper fanMapper;

    @Override
    public long countByExample(FanExample example) {
        return fanMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FanExample example) {
        return fanMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return fanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Fan record) {
        return fanMapper.insert(record);
    }

    @Override
    public int insertSelective(Fan record) {
        return fanMapper.insertSelective(record);
    }

    @Override
    public List<Fan> selectByExample(FanExample example) {
        return fanMapper.selectByExample(example);
    }

    @Override
    public Fan selectByPrimaryKey(Long id) {
        return fanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Fan record,FanExample example) {
        return fanMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Fan record,FanExample example) {
        return fanMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Fan record) {
        return fanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Fan record) {
        return fanMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Fan> list) {
        return fanMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Fan> list) {
        return fanMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Fan> list) {
        return fanMapper.batchInsert(list);
    }

}

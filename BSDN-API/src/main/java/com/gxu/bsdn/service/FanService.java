package com.gxu.bsdn.service;

import java.util.List;
import com.gxu.bsdn.entity.example.FanExample;
import com.gxu.bsdn.entity.Fan;
public interface FanService{


    long countByExample(FanExample example);

    int deleteByExample(FanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Fan record);

    int insertSelective(Fan record);

    List<Fan> selectByExample(FanExample example);

    Fan selectByPrimaryKey(Long id);

    int updateByExampleSelective(Fan record,FanExample example);

    int updateByExample(Fan record,FanExample example);

    int updateByPrimaryKeySelective(Fan record);

    int updateByPrimaryKey(Fan record);

    int updateBatch(List<Fan> list);

    int updateBatchSelective(List<Fan> list);

    int batchInsert(List<Fan> list);

}

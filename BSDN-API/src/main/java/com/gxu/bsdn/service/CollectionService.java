package com.gxu.bsdn.service;

import java.util.List;
import com.gxu.bsdn.entity.Collection;
import com.gxu.bsdn.entity.example.CollectionExample;
public interface CollectionService{


    long countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(Long id);

    int updateByExampleSelective(Collection record,CollectionExample example);

    int updateByExample(Collection record,CollectionExample example);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    int updateBatch(List<Collection> list);

    int updateBatchSelective(List<Collection> list);

    int batchInsert(List<Collection> list);

}

package com.gxu.bsdn.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxu.bsdn.dao.CollectionMapper;
import com.gxu.bsdn.entity.Collection;
import com.gxu.bsdn.entity.example.CollectionExample;
import com.gxu.bsdn.service.CollectionService;
@Service
public class CollectionServiceImpl implements CollectionService{

    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public long countByExample(CollectionExample example) {
        return collectionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CollectionExample example) {
        return collectionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collection record) {
        return collectionMapper.insert(record);
    }

    @Override
    public int insertSelective(Collection record) {
        return collectionMapper.insertSelective(record);
    }

    @Override
    public List<Collection> selectByExample(CollectionExample example) {
        return collectionMapper.selectByExample(example);
    }

    @Override
    public Collection selectByPrimaryKey(Long id) {
        return collectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Collection record,CollectionExample example) {
        return collectionMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Collection record,CollectionExample example) {
        return collectionMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Collection record) {
        return collectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collection record) {
        return collectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Collection> list) {
        return collectionMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Collection> list) {
        return collectionMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Collection> list) {
        return collectionMapper.batchInsert(list);
    }

}

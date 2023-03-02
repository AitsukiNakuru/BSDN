package com.gxu.bsdn.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.bsdn.entity.example.TokenExample;
import com.gxu.bsdn.entity.Token;
import java.util.List;
import com.gxu.bsdn.dao.TokenMapper;
import com.gxu.bsdn.service.TokenService;
@Service
public class TokenServiceImpl implements TokenService{

    @Resource
    private TokenMapper tokenMapper;

    @Override
    public long countByExample(TokenExample example) {
        return tokenMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TokenExample example) {
        return tokenMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tokenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Token record) {
        return tokenMapper.insert(record);
    }

    @Override
    public int insertSelective(Token record) {
        return tokenMapper.insertSelective(record);
    }

    @Override
    public List<Token> selectByExample(TokenExample example) {
        return tokenMapper.selectByExample(example);
    }

    @Override
    public Token selectByPrimaryKey(Long id) {
        return tokenMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Token record,TokenExample example) {
        return tokenMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Token record,TokenExample example) {
        return tokenMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Token record) {
        return tokenMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Token record) {
        return tokenMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Token> list) {
        return tokenMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Token> list) {
        return tokenMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Token> list) {
        return tokenMapper.batchInsert(list);
    }

}

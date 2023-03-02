package com.gxu.bsdn.service;

import com.gxu.bsdn.entity.example.TokenExample;
import com.gxu.bsdn.entity.Token;
import java.util.List;
public interface TokenService{


    long countByExample(TokenExample example);

    int deleteByExample(TokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Token record);

    int insertSelective(Token record);

    List<Token> selectByExample(TokenExample example);

    Token selectByPrimaryKey(Long id);

    int updateByExampleSelective(Token record,TokenExample example);

    int updateByExample(Token record,TokenExample example);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);

    int updateBatch(List<Token> list);

    int updateBatchSelective(List<Token> list);

    int batchInsert(List<Token> list);

}

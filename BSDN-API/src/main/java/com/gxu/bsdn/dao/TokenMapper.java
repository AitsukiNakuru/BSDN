package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Token;
import com.gxu.bsdn.entity.example.TokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TokenMapper {
    long countByExample(TokenExample example);

    int deleteByExample(TokenExample example);

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
    int insert(Token record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Token record);

    List<Token> selectByExample(TokenExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Token selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenExample example);

    int updateByExample(@Param("record") Token record, @Param("example") TokenExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Token record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Token record);

    int updateBatch(List<Token> list);

    int updateBatchSelective(List<Token> list);

    int batchInsert(@Param("list") List<Token> list);
}
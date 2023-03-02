package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Collection;
import com.gxu.bsdn.entity.example.CollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectionMapper {
    long countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

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
    int insert(Collection record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Collection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Collection record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Collection record);

    int updateBatch(List<Collection> list);

    int updateBatchSelective(List<Collection> list);

    int batchInsert(@Param("list") List<Collection> list);
}
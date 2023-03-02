package com.gxu.bsdn.dao;

import com.gxu.bsdn.entity.Admin;
import com.gxu.bsdn.entity.example.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

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
    int insert(Admin record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int updateBatchSelective(List<Admin> list);

    int batchInsert(@Param("list") List<Admin> list);
}
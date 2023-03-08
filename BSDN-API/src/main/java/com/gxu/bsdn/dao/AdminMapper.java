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

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertOrUpdate(Admin record);

    int insertOrUpdateSelective(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int updateBatchSelective(List<Admin> list);

    int batchInsert(@Param("list") List<Admin> list);
}
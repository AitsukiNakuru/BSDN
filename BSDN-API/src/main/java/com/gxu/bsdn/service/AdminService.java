package com.gxu.bsdn.service;

import java.util.List;

import com.gxu.bsdn.entity.Admin;
import com.gxu.bsdn.entity.example.AdminExample;

public interface AdminService {


    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(Admin record, AdminExample example);

    int updateByExample(Admin record, AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int updateBatchSelective(List<Admin> list);

    int batchInsert(List<Admin> list);

    int insertOrUpdate(Admin record);

    int insertOrUpdateSelective(Admin record);


    String login(Admin admin);
}


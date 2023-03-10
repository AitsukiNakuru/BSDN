package com.gxu.bsdn.service.impl;

import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.entity.example.AdminExample;
import com.gxu.bsdn.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import com.gxu.bsdn.entity.Admin;
import com.gxu.bsdn.dao.AdminMapper;
import com.gxu.bsdn.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public long countByExample(AdminExample example) {
        return adminMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

    @Override
    public Admin selectByPrimaryKey(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Admin record, AdminExample example) {
        return adminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Admin record, AdminExample example) {
        return adminMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Admin> list) {
        return adminMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Admin> list) {
        return adminMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Admin> list) {
        return adminMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(Admin record) {
        return adminMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Admin record) {
        return adminMapper.insertOrUpdateSelective(record);
    }

    @Override
    public String login(Admin admin) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (adminList.isEmpty()) {
            return ResultEnum.USERNAME_NOT_EXIST.getResult();
        } else if (!admin.getPassword().equals(adminList.get(0).getPassword())) {
            return ResultEnum.PASSWORD_ERROR.getResult();
        } else {
            return TokenUtils.sign(admin);
        }
    }
}


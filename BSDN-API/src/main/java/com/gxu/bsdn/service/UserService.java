package com.gxu.bsdn.service;

import com.gxu.bsdn.entity.example.UserExample;
import java.util.List;
import com.gxu.bsdn.entity.User;
import com.gxu.bsdn.utils.Result;

public interface UserService{


    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(User record,UserExample example);

    int updateByExample(User record,UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(List<User> list);

    Result login(User user);

    Result update(User user);


    Result register(User user);
    Result logout(User user);
}

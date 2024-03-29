package com.gxu.bsdn.service.impl;

import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import com.gxu.bsdn.utils.TokenUtils;
import com.gxu.bsdn.vo.UserList;
import com.gxu.bsdn.vo.UserWithToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.bsdn.entity.example.UserExample;
import java.util.List;
import com.gxu.bsdn.entity.User;
import com.gxu.bsdn.dao.UserMapper;
import com.gxu.bsdn.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    public Result returnErrorUserList(List<User> userList) {
        if (userList.size() == 0) {
            return ResultGenerator.genFailResult(ResultEnum.USERNAME_NOT_EXIST.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.USERNAME_DUPLICATE.getResult());
        }

    }



    @Override
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(User record,UserExample example) {
        return userMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(User record,UserExample example) {
        return userMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<User> list) {
        return userMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<User> list) {
        return userMapper.batchInsert(list);
    }

    @Override
    public Result login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());

        List<User> loginUserList = userMapper.selectByExample(example);
        if (loginUserList.size() != 1) {
            return returnErrorUserList(loginUserList);
        }
        User loginUser = loginUserList.get(0);
        if (loginUser.getPassword().equals(user.getPassword())) {
            UserWithToken userWithToken = new UserWithToken();
            BeanUtils.copyProperties(loginUser, userWithToken);
            userWithToken.setToken(TokenUtils.sign(user));
            return ResultGenerator.genSuccessResult(ResultEnum.LOGIN_SUCCESS.getResult(), userWithToken);
        }
        return ResultGenerator.genFailResult(ResultEnum.PASSWORD_ERROR.getResult());
    }


    @Override
    public Result update(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(user.getId());
        int updateResult = userMapper.updateByPrimaryKeySelective(user);
        if (updateResult == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.UPDATE_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.UPDATE_FAILURE.getResult());
        }
    }

    @Override
    public Result register(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> userList = userMapper.selectByExample(example);
        if (userList.isEmpty() && userMapper.insertSelective(user) == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.REGISTER_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.REGISTER_FAILURE.getResult()+ "，" +ResultEnum.USERNAME_EXIST.getResult());
        }
    }

    @Override
    public Result logout(User user) {
        return null;
    }

    @Override
    public UserList selectUserList(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameLike('%'+user.getUsername()+'%').andNicknameLike('%'+user.getNickname()+'%').andEmailLike('%'+user.getEmail()+'%');
        List<User> userList = userMapper.selectByExample(example);
        Long userCount = userMapper.countByExample(example);
        UserList result = new UserList();
        result.setUserList(userList);
        result.setUserCount(userCount);
        return result;
    }
}

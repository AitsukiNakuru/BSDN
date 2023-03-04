package com.gxu.bsdn.service.impl;

import com.gxu.bsdn.vo.ArticleWithOther;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxu.bsdn.dao.FanMapper;
import com.gxu.bsdn.entity.example.FanExample;
import com.gxu.bsdn.entity.Fan;
import com.gxu.bsdn.service.FanService;
@Service
public class FanServiceImpl implements FanService{

    @Resource
    private FanMapper fanMapper;

    @Override
    public long countByExample(FanExample example) {
        return fanMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FanExample example) {
        return fanMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return fanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Fan record) {
        return fanMapper.insert(record);
    }

    @Override
    public int insertSelective(Fan record) {
        return fanMapper.insertSelective(record);
    }

    @Override
    public List<Fan> selectByExample(FanExample example) {
        return fanMapper.selectByExample(example);
    }

    @Override
    public Fan selectByPrimaryKey(Long id) {
        return fanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Fan record,FanExample example) {
        return fanMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Fan record,FanExample example) {
        return fanMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Fan record) {
        return fanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Fan record) {
        return fanMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Fan> list) {
        return fanMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Fan> list) {
        return fanMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Fan> list) {
        return fanMapper.batchInsert(list);
    }

    @Override
    public boolean isSubscribe(Long userId, Long authorId) {
        FanExample example = new FanExample();
        FanExample.Criteria criteria = example.createCriteria();
        criteria.andAuthorIdEqualTo(authorId).andFanIdEqualTo(userId);
        List<Fan> fanList = fanMapper.selectByExample(example);
        if (fanList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean subscribe(Long userId, Long authorId) {
        Fan fan = new Fan();
        fan.setFanId(userId);
        fan.setAuthorId(authorId);
        if (fanMapper.insert(fan) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cancelSubscribe(Long userId, Long authorId) {
        FanExample example = new FanExample();
        FanExample.Criteria criteria = example.createCriteria();
        criteria.andAuthorIdEqualTo(authorId).andFanIdEqualTo(userId);
        if (fanMapper.deleteByExample(example) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ArticleWithOther> getSubscribedArticle(Long userId) {
        return fanMapper.selectSubscribeArticle(userId);
    }

    @Override
    public int getFanCount(Long authorId) {
        return fanMapper.getFanCount(authorId);
    }
}

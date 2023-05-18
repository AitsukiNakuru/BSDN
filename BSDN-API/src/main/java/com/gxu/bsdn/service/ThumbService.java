package com.gxu.bsdn.service;

import com.gxu.bsdn.entity.Thumb;
import java.util.List;
import com.gxu.bsdn.entity.example.ThumbExample;
import com.gxu.bsdn.param.ThumbParam;
import com.gxu.bsdn.utils.Result;

public interface ThumbService{


    long countByExample(ThumbExample example);

    int deleteByExample(ThumbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Thumb record);

    int insertSelective(Thumb record);

    List<Thumb> selectByExample(ThumbExample example);

    Thumb selectByPrimaryKey(Long id);

    int updateByExampleSelective(Thumb record,ThumbExample example);

    int updateByExample(Thumb record,ThumbExample example);

    int updateByPrimaryKeySelective(Thumb record);

    int updateByPrimaryKey(Thumb record);

    int updateBatch(List<Thumb> list);

    int updateBatchSelective(List<Thumb> list);

    int batchInsert(List<Thumb> list);

    Result thumbArticle(Thumb thumb);

    Result isThumbArticle(ThumbParam thumbParam);

    Result getThumbCount(Long articleId);

    Result cancelThumb(ThumbParam thumbParam);
}

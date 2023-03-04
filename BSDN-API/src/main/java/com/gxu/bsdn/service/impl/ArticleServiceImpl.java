package com.gxu.bsdn.service.impl;

import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.entity.Category;
import com.gxu.bsdn.entity.example.UserExample;
import com.gxu.bsdn.param.ArticleParam;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxu.bsdn.entity.example.ArticleExample;
import com.gxu.bsdn.entity.Article;
import java.util.List;
import com.gxu.bsdn.dao.ArticleMapper;
import com.gxu.bsdn.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    private ArticleMapper articleMapper;



    @Override
    public long countByExample(ArticleExample example) {
        return articleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleExample example) {
        return articleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Article record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(Article record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public List<Article> selectByExample(ArticleExample example) {
        return articleMapper.selectByExample(example);
    }

    @Override
    public Article selectByPrimaryKey(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Article record,ArticleExample example) {
        return articleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Article record,ArticleExample example) {
        return articleMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Article> list) {
        return articleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Article> list) {
        return articleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Article> list) {
        return articleMapper.batchInsert(list);
    }

    @Override
    public Result publicArticle(Article article) {
        int publicResult =  articleMapper.insertSelective(article);
        if (publicResult == 1) {
            return ResultGenerator.genSuccessResult(ResultEnum.PUBLIC_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.PUBLIC_FAILURE.getResult());
        }
    }

    @Override
    public Result view(Article article) {
        Article articleResult = articleMapper.selectByPrimaryKey(article.getId());

        if (articleResult!=null) {
            article.setViewCount(article.getViewCount()+1);
            articleMapper.updateByPrimaryKeySelective(article);
            return ResultGenerator.genSuccessResult(ResultEnum.SELECT_SUCCESS.getResult(), articleResult);
        } else {
            return ResultGenerator.genFailResult(ResultEnum.SELECT_FAILURE.getResult());
        }
    }

    @Override
    public Result thumbArticle(Article article) {
        Article articleResult = articleMapper.selectByPrimaryKey(article.getId());

        if (articleResult!=null) {
            article.setThumbCount(article.getThumbCount()+1);
            articleMapper.updateByPrimaryKeySelective(article);
            return ResultGenerator.genSuccessResult(ResultEnum.THUMB_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.THUMB_FAILURE.getResult());
        }
    }

    @Override
    public Result collectArticle(Article article) {
        Article articleResult = articleMapper.selectByPrimaryKey(article.getId());
        if (articleResult!=null) {
            article.setCollectCount(article.getCollectCount()+1);
            articleMapper.updateByPrimaryKeySelective(article);
            return ResultGenerator.genSuccessResult(ResultEnum.THUMB_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.THUMB_FAILURE.getResult());
        }
    }

    @Override
    public Result updateArticle(Article article) {
        Article articleResult = articleMapper.selectByPrimaryKey(article.getId());
        if (articleResult!=null) {
            articleMapper.updateByPrimaryKeySelective(article);
            return ResultGenerator.genSuccessResult(ResultEnum.UPDATE_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.UPDATE_FAILURE.getResult());
        }
    }

    @Override
    public Result deleteArticle(Article article) {
        Article articleResult = articleMapper.selectByPrimaryKey(article.getId());
        if (articleResult!=null) {
            articleMapper.deleteByPrimaryKey(article.getId());
            return ResultGenerator.genSuccessResult(ResultEnum.DELETE_SUCCESS.getResult());
        } else {
            return ResultGenerator.genFailResult(ResultEnum.DELETE_FAILURE.getResult());
        }
    }

    @Override
    public Result selectArticle(Article article) {
        Article articleResult = articleMapper.selectByPrimaryKey(article.getId());
        if (articleResult != null) {
            return ResultGenerator.genSuccessResult(ResultEnum.SELECT_SUCCESS.getResult(), articleResult);
        }
        return ResultGenerator.genFailResult(ResultEnum.SELECT_FAILURE.getResult());
    }

    @Override
    public Result selectByParam(ArticleParam articleParam) {
        return ResultGenerator.genSuccessResult(ResultEnum.SELECT_SUCCESS.getResult(), articleMapper.selectByParam(articleParam));
    }

    @Override
    public Result selectByCategoryName(Category category) {
        return ResultGenerator.genSuccessResult(ResultEnum.SELECT_SUCCESS.getResult(), articleMapper.selectByCategoryName(category));
    }

    @Override
    public Result selectById(Long articleId) {
        return ResultGenerator.genSuccessResult(articleMapper.selectById(articleId));
    }
}

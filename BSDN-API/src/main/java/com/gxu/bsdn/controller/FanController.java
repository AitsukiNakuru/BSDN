package com.gxu.bsdn.controller;
import com.github.pagehelper.PageHelper;
import com.gxu.bsdn.common.ResultEnum;
import com.gxu.bsdn.entity.Fan;
import com.gxu.bsdn.param.ArticleParam;
import com.gxu.bsdn.service.FanService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/fan")
public class FanController {

    @Resource
    private FanService fanService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Fan selectOne(Long id) {
        return fanService.selectByPrimaryKey(id);
    }


    @PostMapping("/")
    public Result getSubscribeArticle(@RequestParam Long userId) {
        return null;
    }

    @PostMapping("/isSubscribe")
    public Result isSubscribe(@RequestParam("userId") Long userId, @RequestParam("authorId") Long authorId) {
        if (userId == -1) {
            return ResultGenerator.genSuccessResult(true);
        }
        return ResultGenerator.genSuccessResult(fanService.isSubscribe(userId, authorId));
    }

    @PostMapping("/subscribe")
    public Result subscribe(@RequestParam("userId") Long userId, @RequestParam("authorId") Long authorId) {
        if (fanService.subscribe(userId, authorId)) {
            return ResultGenerator.genSuccessResult(ResultEnum.SUBSCRIBE_SUCCESS.getResult());
        } else {
            return ResultGenerator.genSuccessResult(ResultEnum.SUBSCRIBE_FAILURE.getResult());
        }
    }

    @PostMapping("/cancelSubscribe")
    public Result cancelSubscribe(@RequestParam("userId") Long userId, @RequestParam("authorId") Long authorId) {
        if (fanService.cancelSubscribe(userId, authorId)) {
            return ResultGenerator.genSuccessResult(ResultEnum.CANCEL_SUBSCRIBE_SUCCESS.getResult());
        } else {
            return ResultGenerator.genSuccessResult(ResultEnum.CANCEL_SUBSCRIBE_FAILURE.getResult());
        }
    }
    @PostMapping("/getSubscriptArticle")
    public Result getSubscriptArticle(@RequestParam("userId") Long userId, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        return ResultGenerator.genSuccessResult(fanService.getSubscribedArticle(userId));
    }


    @PostMapping("/getFanCount")
    public Result getFanCount(@RequestParam("authorId") Long authorId) {
        return ResultGenerator.genSuccessResult(fanService.getFanCount(authorId));
    }

}

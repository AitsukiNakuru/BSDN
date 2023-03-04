package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Thumb;
import com.gxu.bsdn.param.ThumbParam;
import com.gxu.bsdn.service.ThumbService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/thumb")
public class ThumbController {

    @Resource
    private ThumbService thumbService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Thumb selectOne(Long id) {
        return thumbService.selectByPrimaryKey(id);
    }

    @PostMapping("/thumb")
    public Result thumbArticle(@RequestBody ThumbParam thumbParam){
        return thumbService.thumbArticle(thumbParam);
    }

    @PostMapping("/isThumb")
    public Result isThumbArticle(@RequestBody ThumbParam thumbParam) {
        if (thumbParam.getUserId() == -1) {
            return ResultGenerator.genSuccessResult(true);
        }
        return thumbService.isThumbArticle(thumbParam);
    }
    @PostMapping("/cancelThumb")
    public Result cancelThumb(@RequestBody ThumbParam thumbParam) {
        return thumbService.cancelThumb(thumbParam);
    }
    @PostMapping("/getThumbCount")
    public Result getThumbCount(@RequestParam("articleId") Long articleId) {
        return thumbService.getThumbCount(articleId);
    }

}

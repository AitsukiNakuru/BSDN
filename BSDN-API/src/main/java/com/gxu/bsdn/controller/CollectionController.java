package com.gxu.bsdn.controller;
import com.github.pagehelper.PageHelper;
import com.gxu.bsdn.entity.Collection;
import com.gxu.bsdn.service.CollectionService;
import com.gxu.bsdn.utils.Result;
import com.gxu.bsdn.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Resource
    private CollectionService collectionService;

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("selectOne")
    public Collection selectOne(Long id) {
        return collectionService.selectByPrimaryKey(id);
    }

    @PostMapping("/isCollected")
    public Result getIsCollected(@RequestBody Collection collection) {
        if (collection.getUserId() == -1) {
            return ResultGenerator.genSuccessResult(true);
        } else {
            return ResultGenerator.genSuccessResult(collectionService.getIsCollected(collection));
        }
    }
    @PostMapping("/addCollection")
    public Result addCollection(@RequestBody Collection collection) {
        return ResultGenerator.genSuccessResult(collectionService.addCollection(collection));
    }
    @PostMapping("/deleteCollection")
    public Result deleteCollection(@RequestBody Collection collection) {
        return ResultGenerator.genSuccessResult(collectionService.deleteCollection(collection));
    }
    @PostMapping("/getCollection")
    public Result getCollection(@RequestParam("userId") Long userId, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return ResultGenerator.genSuccessResult(collectionService.getCollection(userId));
    }
    @PostMapping("/getCollectionCount")
    public Result getCollectionCount(@RequestBody Collection collection) {
        return ResultGenerator.genSuccessResult(collectionService.getCollectionCount(collection));
    }



}

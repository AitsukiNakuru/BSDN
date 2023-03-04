package com.gxu.bsdn.controller;
import com.gxu.bsdn.entity.Collection;
import com.gxu.bsdn.service.CollectionService;
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

    

}

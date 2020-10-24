package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Dishes;
import cn.liuliang.quickdinesysstore.entity.vo.DishesVO;
import cn.liuliang.quickdinesysstore.service.DishesService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Api(value = "菜品管理", tags = "菜品管理")
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    private DishesService dishesService;


    @ApiOperation(value = "获取所有菜品信息", notes = "获取所有菜品信息")
    @GetMapping("/getAll")
    public ResultDTO getAll(@ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Page<Dishes> pageParam = new Page<>(pageNum, pageSize);
        IPage<Dishes> page = dishesService.page(pageParam);
        List<Dishes> records = page.getRecords();
        long total = page.getTotal();
        return ResultDTO.success().data("total", total).data("rows", records);
    }


    @ApiOperation(value = "添加菜品", notes = "添加菜品")
    @PostMapping("/add")
    public ResultDTO add(@RequestBody DishesVO dishesVO) {
        return dishesService.add(dishesVO);
    }


}


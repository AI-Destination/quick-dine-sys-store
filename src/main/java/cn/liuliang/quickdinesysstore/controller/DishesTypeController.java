package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.DishesTypeDTO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesTypeVO;
import cn.liuliang.quickdinesysstore.service.DishesTypeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Api(value = "菜品分类管理", tags = "菜品分类管理")
@CrossOrigin
@RestController
@RequestMapping("/dishes-type")
public class DishesTypeController {

    @Autowired
    private DishesTypeService dishesTypeService;

    @ApiOperation(value = "条件分页查看所有菜品分类信息", notes = "条件分页查看所有菜品分类信息")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = DishesTypeDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            @ApiParam("分类名称查询值") @RequestParam(value = "selectValue", required = false, defaultValue = "") String selectValue,
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return dishesTypeService.selectPage(selectValue, pageNum, pageSize);
    }


    @ApiOperation(value = "添加或修改菜品分类", notes = "添加或修改菜品分类")
    @PostMapping("/add-or-update")
    public ResultDTO addOrUpdateDishesType(@RequestBody DishesTypeVO dishesTypeVO) {
        return dishesTypeService.addOrUpdateDishesType(dishesTypeVO);
    }

    @ApiOperation(value = "删除菜品分类", notes = "删除菜品分类")
    @GetMapping("/delete")
    public ResultDTO delete(@ApiParam("分类id") @RequestParam(value = "分类id", required = true) Long id) {
        return dishesTypeService.delete(id);
    }
}


package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.DishesDTO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesQueryConditionVO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesVO;
import cn.liuliang.quickdinesysstore.service.DishesService;
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
@Api(value = "菜品管理", tags = "菜品管理")
@CrossOrigin
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @ApiOperation(value = "根据条件分页获取所有菜品信息", notes = "根据条件分页获取所有菜品信息")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = DishesDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            DishesQueryConditionVO dishesQueryConditionVO,
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return dishesService.selectAll(dishesQueryConditionVO, pageNum, pageSize);
    }


    @ApiOperation(value = "添加或修改菜品", notes = "添加或修改菜品")
    @PostMapping("/add-or-update")
    public ResultDTO addOrUpdate(@RequestBody DishesVO dishesVO) {
        return dishesService.addOrUpdate(dishesVO);
    }

    @ApiOperation(value = "根据id获取菜品信息", notes = "根据id获取菜品信息")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = DishesDTO.class)})
    @GetMapping("/select-one")
    public ResultDTO selectOne(@ApiParam("菜品id") @RequestParam(value = "id", required = true) Long id) {
        return dishesService.selectOne(id);
    }


    @ApiOperation(value = "根据id删除菜品", notes = "根据id删除菜品")
    @GetMapping("/delete")
    public ResultDTO delete(
            @ApiParam("菜品id") @RequestParam(value = "id", required = true) Long id,
            @ApiParam("菜品照片url") @RequestParam(value = "imgUrl", required = true) String imgUrl) {
        return dishesService.delete(id,imgUrl);
    }

}


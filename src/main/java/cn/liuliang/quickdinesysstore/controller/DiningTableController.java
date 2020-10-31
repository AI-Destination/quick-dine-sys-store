package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.DiningTableDTO;
import cn.liuliang.quickdinesysstore.entity.vo.DiningTableVO;
import cn.liuliang.quickdinesysstore.service.DiningTableService;
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
@Api(value = "餐桌管理", tags = "餐桌管理")
@CrossOrigin
@RestController
@RequestMapping("/dining-table")
public class DiningTableController {

    @Autowired
    private DiningTableService diningTableService;

    @ApiOperation(value = "添加餐桌", notes = "添加餐桌")
    @PostMapping("/add-or-update")
    public ResultDTO addOrUpdate(@RequestBody DiningTableVO diningTableVO) {
        return diningTableService.addOrUpdate(diningTableVO);
    }

    @ApiOperation(value = "分页查看所有餐桌信息", notes = "分页查看所有餐桌信息")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = DiningTableDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return diningTableService.selectAll(pageNum, pageSize);
    }

    @ApiOperation(value = "根据id查询餐桌信息", notes = "根据id查询餐桌信息")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = DiningTableDTO.class)})
    @GetMapping("/select-one")
    public ResultDTO selectOne(@ApiParam("餐桌id") @RequestParam(value = "id", required = false, defaultValue = "1") Long id){
        return diningTableService.selectOne(id);
    }

    @ApiOperation(value = "根据id删除餐桌信息", notes = "根据id删除餐桌信息")
    @GetMapping("/delete")
    public ResultDTO delete(@ApiParam("餐桌id") @RequestParam(value = "id", required = false, defaultValue = "1") Long id){
        diningTableService.removeById(id);
        return ResultDTO.success();
    }


}


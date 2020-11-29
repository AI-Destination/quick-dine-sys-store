package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.LevelDTO;
import cn.liuliang.quickdinesysstore.entity.vo.LevelVO;
import cn.liuliang.quickdinesysstore.service.LevelService;
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
@Api(value = "店家员工级别管理", tags = "店家员工级别管理")
@CrossOrigin
@RestController
@RequestMapping("/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @ApiOperation(value = "添加或修改员工级别", notes = "添加或修改员工级别")
    @PostMapping("/add-or-update")
    public ResultDTO addOrUpdate(@RequestBody LevelVO levelVO) {
        return levelService.addOrUpdate(levelVO);
    }

    @ApiOperation(value = "分页查询所有级别列表", notes = "分页查询所有级别列表")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = LevelDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return levelService.selectAll(pageNum, pageSize);
    }

    @ApiOperation(value = "根据级别id删除级别数据", notes = "根据级别id删除级别数据")
    @GetMapping("/delete")
    public ResultDTO delete(@ApiParam("级别id") @RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
        return ResultDTO.success("data", levelService.removeById(id));
    }

    @ApiOperation(value = "获取所有级别id和名称", notes = "获取所有级别id和名称")
    @GetMapping("/get-id-and-name")
    public ResultDTO getAllLevelIdAndName(){
        return levelService.getAllLevelIdAndName();
    }

}


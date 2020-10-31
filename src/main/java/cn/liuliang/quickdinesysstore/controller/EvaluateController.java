package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.EvaluateDTO;
import cn.liuliang.quickdinesysstore.entity.vo.EvaluateQueryConditionVO;
import cn.liuliang.quickdinesysstore.service.EvaluateService;
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
@Api(value = "评价管理", tags = "评价管理")
@CrossOrigin
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation(value = "条件分页查看所有评论信息", notes = "条件分页查看所有评论信息")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = EvaluateDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            EvaluateQueryConditionVO evaluateQueryConditionVO,
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return evaluateService.selectAll(evaluateQueryConditionVO, pageNum, pageSize);
    }

    @ApiOperation(value = "根据评论id删除评论", notes = "根据评论id删除评论")
    @GetMapping("/delete")
    public ResultDTO delete(@ApiParam("评论id") @RequestParam(value = "id", required = true) Long id) {
        evaluateService.removeById(id);
        return ResultDTO.success();
    }

}


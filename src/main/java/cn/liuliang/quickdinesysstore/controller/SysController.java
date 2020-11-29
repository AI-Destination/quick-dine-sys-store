package cn.liuliang.quickdinesysstore.controller;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.SysDataDTO;
import cn.liuliang.quickdinesysstore.service.SysService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package： cn.liuliang.quickdinesysstore.controller
 * @Author： liuliang
 * @CreateTime： 2020/11/8 - 13:27
 * @Description：
 */
@Api(value = "系统管理", tags = "系统管理")
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private SysService sysService;

    @ApiOperation(value = "获取系统的结账时积分计算比例", notes = "获取系统的结账时积分计算比例")
    @GetMapping("/get-integral-ratio")
    public ResultDTO getIntegralRatio(){
        return sysService.getIntegralRatio();
    }

    @ApiOperation(value = "修改结账时积分计算比例", notes = "修改结账时积分计算比例")
    @GetMapping("/update-integral-ratio")
    public ResultDTO updateIntegralRatio(@ApiParam("积分比例") @RequestParam(value = "integralRatio", required = true) Integer integralRatio){
        return sysService.updateIntegralRatio(integralRatio);
    }

    @ApiOperation(value = "获取系统相关数据", notes = "获取系统相关数据")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = SysDataDTO.class)})
    @GetMapping("/get-data")
    public ResultDTO getData(@ApiParam("时间字符串") @RequestParam(value = "strTime", required = false, defaultValue = "") String strTime){
        return sysService.getData(strTime);
    }


}

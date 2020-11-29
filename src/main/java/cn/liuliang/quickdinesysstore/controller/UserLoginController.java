package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Api(value ="店家后端用户登入" , tags = "店家后端用户登入（模拟的，未开发功能）")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @ApiOperation(value = "后端用户登录", notes = "后端用户登录")
    @PostMapping("/login")
    public ResultDTO login(){
        return ResultDTO.success("token","admin");
    }

    @ApiOperation(value = "获取身份信息", notes = "获取身份信息")
    @GetMapping("/info")
    public ResultDTO info(){
        return ResultDTO.success()
                .data("name","admin")
                .data("roles","[admin]")
                .data("avatar","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSocqk7MXjzH8GAxhrGj0CnMWrq1Eup--RyQA&usqp=CAU");
    }

    @ApiOperation(value = "用户注销", notes = "用户注销")
    @PostMapping("/logout")
    public ResultDTO logout(){
        return ResultDTO.success();
    }

}


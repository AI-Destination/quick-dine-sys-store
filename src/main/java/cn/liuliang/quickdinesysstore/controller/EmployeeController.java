package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.EmployeeDTO;
import cn.liuliang.quickdinesysstore.entity.dto.EmployeeDetailDTO;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeQueryVO;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeVO;
import cn.liuliang.quickdinesysstore.service.EmployeeService;
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
@Api(value = "店家员工管理", tags = "店家员工管理")
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "添加或修改员工", notes = "添加或修改员工")
    @PostMapping("/add-or-update")
    public ResultDTO addOrUpdate(@RequestBody EmployeeVO employeeVO) {
        return employeeService.addOrUpdate(employeeVO);
    }

    @ApiOperation(value = "分页查询所有员工列表", notes = "分页查询所有员工列表")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = EmployeeDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            EmployeeQueryVO employeeQueryVO,
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return employeeService.selectAll(pageNum, pageSize, employeeQueryVO);
    }

    @ApiOperation(value = "根据员工id查询详情", notes = "根据员工id查询详情")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = EmployeeDetailDTO.class)})
    @GetMapping("/select-one")
    public ResultDTO selectOne(@ApiParam("员工id") @RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
        return employeeService.selectOne(id);
    }


    @ApiOperation(value = "根据员工id删除员工数据", notes = "根据员工id删除员工数据")
    @GetMapping("/delete")
    public ResultDTO delete(@ApiParam("员工id") @RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
        return ResultDTO.success("data", employeeService.removeById(id));
    }


}


package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.OrderDTO;
import cn.liuliang.quickdinesysstore.entity.dto.OrderDetailDTO;
import cn.liuliang.quickdinesysstore.entity.vo.OrderQueryConditionVO;
import cn.liuliang.quickdinesysstore.service.OrderService;
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
@Api(value = "订单管理", tags = "订单管理")
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "分页条件查询所有订单列表", notes = "分页条件查询所有订单列表")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = OrderDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAll(
            OrderQueryConditionVO orderQueryConditionVO,
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return orderService.selectAll(orderQueryConditionVO, pageNum, pageSize);
    }

    @ApiOperation(value = "根据id查询订单详情", notes = "根据id查询订单详情")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = OrderDetailDTO.class)})
    @GetMapping("/select-one")
    public ResultDTO selectOne(@ApiParam("订单id") @RequestParam(value = "id", required = true) Long id) {
        return orderService.selectOne(id);
    }

    @ApiOperation(value = "根据id删除订单", notes = "根据id删除订单")
    @GetMapping("/delete")
    public ResultDTO delete(@ApiParam("订单id") @RequestParam(value = "id", required = true) Long id){
        return orderService.delete(id);
    }

/*    @ApiOperation(value = "根据订单id进行结账", notes = "根据订单id进行结账")
    @GetMapping("/bill-please")
    public ResultDTO billPlease(@ApiParam("订单id") @RequestParam(value = "id", required = true) Long id){
        return orderService.billPlease(id);
    }*/


}


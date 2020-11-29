package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.DiningTable;
import cn.liuliang.quickdinesysstore.entity.Order;
import cn.liuliang.quickdinesysstore.entity.dto.AlreadyOrderDishesDTO;
import cn.liuliang.quickdinesysstore.entity.dto.OrderDTO;
import cn.liuliang.quickdinesysstore.entity.dto.OrderDetailDTO;
import cn.liuliang.quickdinesysstore.entity.vo.OrderQueryConditionVO;
import cn.liuliang.quickdinesysstore.mapper.DiningTableMapper;
import cn.liuliang.quickdinesysstore.mapper.OrderMapper;
import cn.liuliang.quickdinesysstore.service.OrderService;
import cn.liuliang.quickdinesysstore.utils.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DiningTableMapper diningTableMapper;

    @Autowired
    private QueryUtils queryUtils;

    @Override
    public ResultDTO selectAll(OrderQueryConditionVO orderQueryConditionVO, Integer pageNum, Integer pageSize) {
        // 构造分页
        Page<Order> orderPage = new Page<>(pageNum, pageSize);
        // 设置查询店家名称条件
        orderQueryConditionVO.setStoreName(queryUtils.getStoreName());
        // 执行查询
        List<Order> orderList = orderMapper.selectAll(orderPage, orderQueryConditionVO);
        // 构造数据
        List<OrderDTO> orderDTOList = new ArrayList<>(orderList.size());
        orderList.forEach(order -> {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(order, orderDTO);
            orderDTOList.add(orderDTO);
        });
        return ResultDTO.success().data("total", Math.toIntExact(orderPage.getTotal())).data("rows", orderDTOList);
    }

    @Override
    public ResultDTO selectOne(Long id) {
        // 查询订单基本信息
        Order order = orderMapper.selectById(id);
        // 根据订单中的点菜id，查询点菜列表
        List<AlreadyOrderDishesDTO> alreadyOrderDishesDTOList = orderMapper.selectAlreadyOrderDishesByFoods(order.getFoods());
        // 计算点菜条目中的合计字段
        alreadyOrderDishesDTOList.forEach(alreadyOrderDishesDTO -> {
            alreadyOrderDishesDTO.setSumPrice(alreadyOrderDishesDTO.getPrice().multiply(new BigDecimal(alreadyOrderDishesDTO.getNumber())));
        });
        // 组装数据
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        // 组装订单基本数据
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        orderDTO.setDiscountRate(orderDTO.getDescription().split(";")[0]);
        orderDTO.setPointsDeduction(orderDTO.getDescription().split(";")[1]);
        // 设置订单菜品信息
        orderDetailDTO.setOrderDTO(orderDTO);
        orderDetailDTO.setAlreadyOrderDishesDTOList(alreadyOrderDishesDTOList);
        return ResultDTO.success().data("data", orderDetailDTO);
    }

    @Override
    public ResultDTO delete(Long id) {
        // 根据订单id ， 查询其下面的所有一点菜品id（foods）
        // 构造查询条件对象
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.select("foods").eq("id", id);
        Order order = orderMapper.selectOne(orderQueryWrapper);
        // 开始删除订单基本信息
        orderMapper.deleteById(id);
        // 开始删除订单下的以点菜品信息
        orderMapper.deleteAlreadyOrderDishes(order.getFoods());
        return ResultDTO.success();
    }

    @Transactional
    @Override
    public ResultDTO billPlease(Long id) {
        // 获取订单的餐桌号
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.select("dining_table_number").eq("id", id);
        Order order = orderMapper.selectOne(orderQueryWrapper);
        // 修改餐桌状态为空闲和下单状态为未下单
        UpdateWrapper<DiningTable> diningTableUpdateWrapper = new UpdateWrapper<>();
        DiningTable diningTable = new DiningTable();
        //diningTable.setIsLeisure(1);
        //diningTable.setIsOrder(2);
        diningTableUpdateWrapper.eq("dining_table_number", order.getDiningTableNumber());
        diningTableMapper.update(diningTable, diningTableUpdateWrapper);
        // 修改订单的结账状态为结账
        UpdateWrapper<Order> orderUpdateWrapper = new UpdateWrapper<>();
        Order order1 = new Order();
        order1.setIsSettleAccounts(1);
        diningTableUpdateWrapper.eq("id", id);
        orderMapper.update(order1, orderUpdateWrapper);
        // 结账成功 ,返回结果
        return ResultDTO.success();
    }
}

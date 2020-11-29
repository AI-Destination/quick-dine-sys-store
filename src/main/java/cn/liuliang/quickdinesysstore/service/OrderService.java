package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Order;
import cn.liuliang.quickdinesysstore.entity.vo.OrderQueryConditionVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface OrderService extends IService<Order> {

    /**
     * 分页条件查询所有订单列表
     *
     * @param orderQueryConditionVO 订单查询条件对象
     * @param pageNum               当前页
     * @param pageSize              每页大小
     * @return
     */
    ResultDTO selectAll(OrderQueryConditionVO orderQueryConditionVO, Integer pageNum, Integer pageSize);

    /**
     * 根据订单 id 查询订单详情
     *
     * @param id 订单id
     * @return
     */
    ResultDTO selectOne(Long id);

    /**
     * 根据订单id删除订单
     *
     * @param id 订单id
     * @return
     */
    ResultDTO delete(Long id);

    /**
     * 根据订单id进行结账
     *
     * @param id  订单id
     * @return
     */
    ResultDTO billPlease(Long id);
}

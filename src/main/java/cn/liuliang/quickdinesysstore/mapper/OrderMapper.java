package cn.liuliang.quickdinesysstore.mapper;

import cn.liuliang.quickdinesysstore.entity.Order;
import cn.liuliang.quickdinesysstore.entity.dto.AlreadyOrderDishesDTO;
import cn.liuliang.quickdinesysstore.entity.vo.OrderQueryConditionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 分页条件查询所有订单列表
     *
     * @param orderPage             分页对象
     * @param orderQueryConditionVO 查询条件对象
     * @return
     */
    List<Order> selectAll(@Param("orderPage") Page<Order> orderPage, @Param("orderQueryConditionVO") OrderQueryConditionVO orderQueryConditionVO);

    /**
     * 根据订单中已点菜foods字段查询订单的所有菜品
     *
     * @param foods 已点菜字段
     * @return
     */
    List<AlreadyOrderDishesDTO> selectAlreadyOrderDishesByFoods(@Param("foods") Long foods);

    /**
     * 删除订单下的以点菜品信息
     *
     * @param foods id
     */
    void deleteAlreadyOrderDishes(@Param("foods") Long foods);

}

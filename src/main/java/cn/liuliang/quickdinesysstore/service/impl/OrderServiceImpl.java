package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.entity.Order;
import cn.liuliang.quickdinesysstore.mapper.OrderMapper;
import cn.liuliang.quickdinesysstore.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

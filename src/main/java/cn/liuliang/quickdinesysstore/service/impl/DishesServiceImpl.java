package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Dishes;
import cn.liuliang.quickdinesysstore.entity.vo.DishesVO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import cn.liuliang.quickdinesysstore.mapper.DishesMapper;
import cn.liuliang.quickdinesysstore.service.DishesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Service
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements DishesService {

    @Autowired
    private DishesMapper dishesMapper;

    @Override
    public ResultDTO add(DishesVO dishesVO) {
        Dishes dishes = new Dishes();
        BeanUtils.copyProperties(dishesVO, dishes);
        boolean save = this.save(dishes);
        if (save) {
            return ResultDTO.success();
        } else {
            // 抛出自定义异常
            throw new QuickException("插入失败", 400);
        }
    }
}

package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Dishes;
import cn.liuliang.quickdinesysstore.entity.vo.DishesVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface DishesService extends IService<Dishes> {

    /**
     * 添加菜品
     * @param dishesVO
     * @return
     */
    ResultDTO add(DishesVO dishesVO);

}

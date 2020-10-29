package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Dishes;
import cn.liuliang.quickdinesysstore.entity.vo.DishesQueryConditionVO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface DishesService extends IService<Dishes> {

    /**
     * 添加菜品或修改菜品
     *
     * @param dishesVO 菜品信息
     * @return
     */
    ResultDTO addOrUpdate(DishesVO dishesVO);

    /**
     * 根据条件分页获取所有菜品信息
     *
     * @param dishesQueryConditionVO 查询条件对象
     * @param pageNum                当前页
     * @param pageSize               每页数量
     * @return
     */
    ResultDTO selectAll(DishesQueryConditionVO dishesQueryConditionVO, Integer pageNum, Integer pageSize);

    /**
     * 根据id获取菜品
     * @param id    菜品id
     * @return
     */
    ResultDTO selectOne(Long id);
}

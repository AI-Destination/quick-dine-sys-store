package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.DishesType;
import cn.liuliang.quickdinesysstore.entity.vo.DishesTypeVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface DishesTypeService extends IService<DishesType> {

    /**
     * 分页条件查询菜品种类列表
     * @param selectValue   查询条件
     * @param pageNum       当前页
     * @param pageSize      每页数量
     * @return
     */
    ResultDTO selectPage(String selectValue, Integer pageNum, Integer pageSize);

    /**
     * 添加或修改菜品分类
     * @param dishesTypeVO  分类名称相关信息
     * @return
     */
    ResultDTO addOrUpdateDishesType(DishesTypeVO dishesTypeVO);

    /**
     * 删除菜品分类
     * @param id    菜品分类id
     * @return
     */
    ResultDTO delete(Long id);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    ResultDTO selectOne(Long id);
}

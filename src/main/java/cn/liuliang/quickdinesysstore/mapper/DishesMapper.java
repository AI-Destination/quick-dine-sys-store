package cn.liuliang.quickdinesysstore.mapper;

import cn.liuliang.quickdinesysstore.entity.Dishes;
import cn.liuliang.quickdinesysstore.entity.vo.DishesQueryConditionVO;
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
public interface DishesMapper extends BaseMapper<Dishes> {

    /**
     * 根据条件分页查询菜品列表
     *
     * @param dishesPage             分页对象
     * @param dishesQueryConditionVO 条件对象
     * @return
     */
    List<Dishes> selectAll(@Param("dishesPage") Page<Dishes> dishesPage, @Param("dishesQueryConditionVO") DishesQueryConditionVO dishesQueryConditionVO);
}

package cn.liuliang.quickdinesysstore.mapper;

import cn.liuliang.quickdinesysstore.entity.Evaluate;
import cn.liuliang.quickdinesysstore.entity.vo.EvaluateQueryConditionVO;
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
public interface EvaluateMapper extends BaseMapper<Evaluate> {

    /**
     * 根据条件分页查询评论数据
     *
     * @param evaluatePage             分页对象
     * @param evaluateQueryConditionVO 查询条件对象
     * @return
     */
    List<Evaluate> selectAll(@Param("evaluatePage") Page<Evaluate> evaluatePage, @Param("evaluateQueryConditionVO") EvaluateQueryConditionVO evaluateQueryConditionVO);

}

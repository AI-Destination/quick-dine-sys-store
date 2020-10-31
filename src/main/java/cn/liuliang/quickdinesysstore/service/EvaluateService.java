package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Evaluate;
import cn.liuliang.quickdinesysstore.entity.vo.EvaluateQueryConditionVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface EvaluateService extends IService<Evaluate> {

    /**
     * 条件分页查看所有评论信息
     * @param evaluateQueryConditionVO  查询条件
     * @param pageNum                   当前页
     * @param pageSize                  每页大小
     * @return
     */
    ResultDTO selectAll(EvaluateQueryConditionVO evaluateQueryConditionVO, Integer pageNum, Integer pageSize);
}

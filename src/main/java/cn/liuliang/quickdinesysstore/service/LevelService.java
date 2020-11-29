package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Level;
import cn.liuliang.quickdinesysstore.entity.vo.LevelVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface LevelService extends IService<Level> {

    /**
     *
     * @param levelVO   级别信息对象
     * @return
     */
    ResultDTO addOrUpdate(LevelVO levelVO);

    /**
     * 分页查询所有级别列表
     * @param pageNum   当前页
     * @param pageSize  每页大小
     * @return
     */
    ResultDTO selectAll(Integer pageNum, Integer pageSize);

    /**
     * 获取所有级别id和名称
     * @return
     */
    ResultDTO getAllLevelIdAndName();


}

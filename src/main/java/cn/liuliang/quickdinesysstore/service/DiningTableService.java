package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.DiningTable;
import cn.liuliang.quickdinesysstore.entity.vo.DiningTableVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface DiningTableService extends IService<DiningTable> {

    /**
     * 添加餐桌
     *
     * @param diningTableVO 餐桌信息
     * @return
     */
    ResultDTO addOrUpdate(DiningTableVO diningTableVO);

    /**
     * 分页查看所有餐桌信息
     *
     * @param pageNum  当前页
     * @param pageSize 每页大小
     * @return
     */
    ResultDTO selectAll(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询餐桌信息
     *
     * @param id 餐桌id
     * @return
     */
    ResultDTO selectOne(Long id);
}

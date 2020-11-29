package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.CookingSkillImages;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface CookingSkillImagesService extends IService<CookingSkillImages> {

    /**
     * 分页查询厨艺秀图片列表
     * @param pageNum   当前页
     * @param pageSize  每页数量
     * @return
     */
    ResultDTO selectPage(Integer pageNum, Integer pageSize);

    /**
     * 添加图片url数组
     * @param url 图片url数组
     * @return
     */
    ResultDTO addCookingSkillImages(String url);

    /**
     * 删除图片
     * @param id    图片id
     * @param url   图片url
     * @return
     */
    ResultDTO delete(Long id, String url);

}

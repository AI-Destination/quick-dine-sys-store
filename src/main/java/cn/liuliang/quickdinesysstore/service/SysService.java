package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;

/**
 * @Package： cn.liuliang.quickdinesysstore.service
 * @Author： liuliang
 * @CreateTime： 2020/11/26 - 20:05
 * @Description：
 */
public interface SysService {

    /**
     * 获取系统的结账时积分计算比例
     * @return
     */
    ResultDTO getIntegralRatio();

    /**
     * 修改结账时积分计算比例
     * @param integralRatio
     * @return
     */
    ResultDTO updateIntegralRatio(Integer integralRatio);

    /**
     * 获取系统相关数据
     * @param strTime 时间范围字符串
     * @return
     */
    ResultDTO getData(String strTime);
}

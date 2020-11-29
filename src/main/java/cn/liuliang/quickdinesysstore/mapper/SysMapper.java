package cn.liuliang.quickdinesysstore.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.mapper
 * @Author： liuliang
 * @CreateTime： 2020/11/26 - 20:08
 * @Description：
 */

public interface SysMapper {

    /**
     * 获取系统的结账时积分计算比例
     *
     * @return
     */
    Integer getIntegralRatio();

    /**
     * 修改结账时积分计算比例
     *
     * @param integralRatio
     * @return
     */
    void updateIntegralRatio(@Param("integralRatio") Integer integralRatio);

    /**
     * 查询用户数据
     *
     * @param weekPer   查询星期几的数据
     * @param level     身份：1全部，2会员，3用户，4游客
     * @param per       1全查，2时间范围查询
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    Integer getUserData(@Param("weekPer") int weekPer, @Param("level") int level, @Param("per") int per, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 查询评论数据
     *
     * @param weekPer   查询星期几的数据
     * @param level     身份：1全部，2会员，3用户，4游客
     * @param per       1全查，2时间范围查询
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    Integer getDiscussData(@Param("weekPer") int weekPer, @Param("level") int level, @Param("per") int per, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 查询交易数据
     *
     * @param weekPer   查询星期几的数据
     * @param level     身份：1全部，2会员，3用户，4游客
     * @param per       1全查，2时间范围查询
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    BigDecimal getTransactionData(@Param("weekPer") int weekPer, @Param("level") int level, @Param("per") int per, @Param("startTime") String startTime, @Param("endTime") String endTime);


    /**
     * 查询订单数据
     *
     * @param weekPer   查询星期几的数据
     * @param level     身份：1全部，2会员，3用户，4游客
     * @param per       1全查，2时间范围查询
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    Integer getOrderData(@Param("weekPer") int weekPer, @Param("level") int level, @Param("per") int per, @Param("startTime") String startTime, @Param("endTime") String endTime);
}

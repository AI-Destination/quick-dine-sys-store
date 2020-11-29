package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.*;
import cn.liuliang.quickdinesysstore.mapper.SysMapper;
import cn.liuliang.quickdinesysstore.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.service.impl
 * @Author： liuliang
 * @CreateTime： 2020/11/26 - 20:06
 * @Description：
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysMapper sysMapper;

    @Override
    public ResultDTO getIntegralRatio() {
        Integer proportionIntegral = sysMapper.getIntegralRatio();
        return ResultDTO.success().data("data", proportionIntegral);
    }

    @Override
    public ResultDTO updateIntegralRatio(Integer integralRatio) {
        sysMapper.updateIntegralRatio(integralRatio);
        return ResultDTO.success();
    }

    @Override
    public ResultDTO getData(String strTime) {
        // 查询标识，1：查询所有数据（默认查所有），2：查询对应时间范围内数据
        int per = 1;
        // 开始时间
        String startTime = "";
        // 结束时间
        String endTime = "";
        if (!StringUtils.isEmpty(strTime)) {
            // 查询对应时间范围内数据
            per = 2;
            startTime = strTime.split(";")[0];
            endTime = strTime.split(";")[1];
        }
        SysDataDTO sysDataDTO = new SysDataDTO();
        // 设置用户相关数据
        sysDataDTO.setSysUserDataDTO(userData(per, startTime, endTime));
        // 设置评论相关数据
        sysDataDTO.setSysDiscussDataDTO(discussData(per, startTime, endTime));
        // 设置交易额相关数据
        sysDataDTO.setSysTransactionDataDTO(transactionData(per, startTime, endTime));
        // 设置订单相关数据
        sysDataDTO.setSysOrderDataDTO(orderData(per, startTime, endTime));
        return ResultDTO.success("data", sysDataDTO);
    }

    private SysOrderDataDTO orderData(int per, String startTime, String endTime) {
        SysOrderDataDTO sysOrderDataDTO = new SysOrderDataDTO();
        Integer[] orderTotal = new Integer[8];
        Integer[] memberOrderNumber = new Integer[8];
        Integer[] userOrderNumber = new Integer[8];
        Integer[] touristOrderNumber = new Integer[8];
        // 查询数据
        for (int i = 1; i <= 8; i++) {
            // 查询星期一 到 星期日的数据 及 总数据
            orderTotal[i - 1] = sysMapper.getOrderData(i, 1, per, startTime, endTime);
            memberOrderNumber[i - 1] = sysMapper.getOrderData(i, 2, per, startTime, endTime);
            userOrderNumber[i - 1] = sysMapper.getOrderData(i, 3, per, startTime, endTime);
            touristOrderNumber[i - 1] = sysMapper.getOrderData(i, 4, per, startTime, endTime);
        }
        sysOrderDataDTO.setOrderTotal(orderTotal);
        sysOrderDataDTO.setMemberOrderNumber(memberOrderNumber);
        sysOrderDataDTO.setUserOrderNumber(userOrderNumber);
        sysOrderDataDTO.setTouristOrderNumber(touristOrderNumber);
        return sysOrderDataDTO;
    }

    private SysDiscussDataDTO discussData(int per, String startTime, String endTime) {
        SysDiscussDataDTO sysDiscussDataDTO = new SysDiscussDataDTO();
        Integer[] discussTotal = new Integer[8];
        Integer[] memberDiscussNumber = new Integer[8];
        Integer[] userDiscussNumber = new Integer[8];
        Integer[] touristDiscussNumber = new Integer[8];
        // 查询数据
        for (int i = 1; i <= 8; i++) {
            // 查询星期一 到 星期日的数据 及 总数据
            discussTotal[i - 1] = sysMapper.getDiscussData(i, 1, per, startTime, endTime);
            memberDiscussNumber[i - 1] = sysMapper.getDiscussData(i, 2, per, startTime, endTime);
            userDiscussNumber[i - 1] = sysMapper.getDiscussData(i, 3, per, startTime, endTime);
            touristDiscussNumber[i - 1] = sysMapper.getDiscussData(i, 4, per, startTime, endTime);
        }
        sysDiscussDataDTO.setDiscussTotal(discussTotal);
        sysDiscussDataDTO.setMemberDiscussNumber(memberDiscussNumber);
        sysDiscussDataDTO.setUserDiscussNumber(userDiscussNumber);
        sysDiscussDataDTO.setTouristDiscussNumber(touristDiscussNumber);
        return sysDiscussDataDTO;
    }

    private SysUserDataDTO userData(int per, String startTime, String endTime) {
        SysUserDataDTO sysUserDataDTO = new SysUserDataDTO();
        Integer[] userData = new Integer[8];
        Integer[] memberNumber = new Integer[8];
        Integer[] userNumber = new Integer[8];
        Integer[] touristNumber = new Integer[8];
        // 查询数据
        for (int i = 1; i <= 8; i++) {
            // 查询星期一 到 星期日的数据 及 总数据
            userData[i - 1] = sysMapper.getUserData(i, 1, per, startTime, endTime);
            memberNumber[i - 1] = sysMapper.getUserData(i, 2, per, startTime, endTime);
            userNumber[i - 1] = sysMapper.getUserData(i, 3, per, startTime, endTime);
            touristNumber[i - 1] = sysMapper.getUserData(i, 4, per, startTime, endTime);
        }
        sysUserDataDTO.setUserTotal(userData);
        sysUserDataDTO.setMemberNumber(memberNumber);
        sysUserDataDTO.setUserNumber(userNumber);
        sysUserDataDTO.setTouristNumber(touristNumber);
        return sysUserDataDTO;
    }

    private SysTransactionDataDTO transactionData(int per, String startTime, String endTime) {
        SysTransactionDataDTO sysTransactionDataDTO = new SysTransactionDataDTO();
        BigDecimal[] transactionAmountTotal = new BigDecimal[8];
        BigDecimal[] memberTransactionAmount = new BigDecimal[8];
        BigDecimal[] userTransactionAmount = new BigDecimal[8];
        BigDecimal[] touristTransactionAmount = new BigDecimal[8];
        // 查询数据
        for (int i = 1; i <= 8; i++) {
            // 查询星期一 到 星期日的数据 及 总数据
            transactionAmountTotal[i - 1] = sysMapper.getTransactionData(i, 1, per, startTime, endTime);
            if (null == transactionAmountTotal[i - 1]) {
                transactionAmountTotal[i - 1] = new BigDecimal(0);
            }
            memberTransactionAmount[i - 1] = sysMapper.getTransactionData(i, 2, per, startTime, endTime);
            if (null == memberTransactionAmount[i - 1]) {
                memberTransactionAmount[i - 1] = new BigDecimal(0);
            }
            userTransactionAmount[i - 1] = sysMapper.getTransactionData(i, 3, per, startTime, endTime);
            if (null == userTransactionAmount[i - 1]) {
                userTransactionAmount[i - 1] = new BigDecimal(0);
            }
            touristTransactionAmount[i - 1] = sysMapper.getTransactionData(i, 4, per, startTime, endTime);
            if (null == touristTransactionAmount[i - 1]) {
                touristTransactionAmount[i - 1] = new BigDecimal(0);
            }
        }
        sysTransactionDataDTO.setTransactionAmountTotal(transactionAmountTotal);
        sysTransactionDataDTO.setMemberTransactionAmount(memberTransactionAmount);
        sysTransactionDataDTO.setUserTransactionAmount(userTransactionAmount);
        sysTransactionDataDTO.setTouristTransactionAmount(touristTransactionAmount);
        return sysTransactionDataDTO;
    }
}

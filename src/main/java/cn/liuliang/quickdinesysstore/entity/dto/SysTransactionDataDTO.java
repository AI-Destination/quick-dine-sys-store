package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/11/27 - 8:37
 * @Description：
 */
@Data
@ApiModel(value = "系统交易相关数据DTO", description = "")
public class SysTransactionDataDTO {

    @ApiModelProperty(value = "总交易额")
    private BigDecimal[] transactionAmountTotal;

    @ApiModelProperty(value = "会员交易额")
    private BigDecimal[] memberTransactionAmount;

    @ApiModelProperty(value = "用户交易额")
    private BigDecimal[] userTransactionAmount;

    @ApiModelProperty(value = "游客交易额")
    private BigDecimal[] touristTransactionAmount;

}
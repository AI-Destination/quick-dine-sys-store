package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/10/30 - 8:53
 * @Description：
 */
@Data
@ApiModel(value="订单信息DTO", description="")
public class OrderDTO implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "店家名称：唯一")
    private String storeName;

    @ApiModelProperty(value = "桌号：关联餐桌表中的id")
    private String diningTableNumber;

    @ApiModelProperty(value = "下单人名称")
    private String orderDishesPeopleName;

    @ApiModelProperty(value = "下单人电话")
    private String orderDishesPeoplePhone;

    @ApiModelProperty(value = "已点菜品：生成id，关联已点菜表id")
    private Long foods;

    @ApiModelProperty(value = "金额")
    private BigDecimal money;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal actualMoney;

    @ApiModelProperty(value = "金额来源描述（优惠率，积分抵扣）")
    private String description;

    @ApiModelProperty(value = "优惠率")
    private String discountRate;

    @ApiModelProperty(value = "积分抵扣")
    private String pointsDeduction;

    @ApiModelProperty(value = "积分：每十块抵一积分，积分可以在结账时抵扣，一积分抵扣一块钱（这个以后后台需要可设置话）")
    private Integer integral;

    @ApiModelProperty(value = "是否结账：1：结账，2：未结账")
    private Integer isSettleAccounts;

    @ApiModelProperty(value = "是否结账")
    private Date orderTime;

    @ApiModelProperty(value = "结账时间")
    private Date settleAccountsTime;
}

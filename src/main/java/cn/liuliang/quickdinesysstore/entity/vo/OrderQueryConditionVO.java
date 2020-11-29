package cn.liuliang.quickdinesysstore.entity.vo;

import cn.liuliang.quickdinesysstore.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/30 - 8:40
 * @Description：
 */
@Data
@ApiModel(value = "订单查询vo", description = "")
public class OrderQueryConditionVO extends BaseVO {

    @ApiModelProperty(value = "桌号：关联餐桌表中的id")
    private String diningTableNumber;

    @ApiModelProperty(value = "是否结账：1：结账，2：未结账")
    private Integer isSettleAccounts;

    @ApiModelProperty(value = "下单人电话")
    private String orderDishesPeoplePhone;

    @ApiModelProperty(value = "金额")
    private BigDecimal money;

    @ApiModelProperty(value = "下单时间")
    private String orderTime;


}

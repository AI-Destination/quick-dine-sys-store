package cn.liuliang.quickdinesysstore.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import cn.liuliang.quickdinesysstore.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_order")
@ApiModel(value="Order对象", description="")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "积分：每十块抵一积分，积分可以在结账时抵扣，一积分抵扣一块钱（这个以后后台需要可设置话）")
    private Integer integral;

    @ApiModelProperty(value = "是否结账：1：结账，2：未结账")
    private Integer isSettleAccounts;

    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

    @ApiModelProperty(value = "结账时间")
    private Date settleAccountsTime;


}

package cn.liuliang.quickdinesysstore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_dining_table")
@ApiModel(value="DiningTable对象", description="")
public class DiningTable extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桌号：不为空，唯一")
    private String diningTableNumber;

    @ApiModelProperty(value = "餐桌名称：特色名称，有利于店面文怀")
    private String diningTableName;

    @ApiModelProperty(value = "是否下单：1：下单，2，未下单；下单之后，要修改这个状态")
    private Integer isOrder;

    @ApiModelProperty(value = "就餐人数")
    private Integer eatNumberPeople;

    @ApiModelProperty(value = "是否预定：1：预定，2，未预定；预定之后不可在被他人使用")
    private Integer isReserve;

    @ApiModelProperty(value = "是否空闲：1：空闲，2，不空闲；空闲餐桌才可应就餐")
    private Integer isLeisure;


}

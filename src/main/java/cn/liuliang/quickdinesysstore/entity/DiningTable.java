package cn.liuliang.quickdinesysstore.entity;

import cn.liuliang.quickdinesysstore.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @ApiModelProperty(value = "状态：1空闲，2下单，3预定")
    private Integer state;

    @ApiModelProperty(value = "就餐人数")
    private Integer eatNumberPeople;

    @ApiModelProperty(value = "预定人id，就是登录的用户id")
    private Long reserveUserId;

}

package cn.liuliang.quickdinesysstore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.liuliang.quickdinesysstore.base.BaseEntity;
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
@TableName("t_already_order_dishes")
@ApiModel(value="AlreadyOrderDishes对象", description="")
public class AlreadyOrderDishes extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜Id：关联菜品表，根据这个菜品id可以查到菜品所有信息")
    private Long dishesId;

    @ApiModelProperty(value = "数量")
    private Integer number;


}

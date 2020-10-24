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
@TableName("t_user_info")
@ApiModel(value="UserInfo对象", description="")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身份类型：用户，会员")
    private String identityType;

    @ApiModelProperty(value = "优惠值：用户无优惠但有积分，会员有优惠（9折）而且还有积分")
    private Float discounts;

    @ApiModelProperty(value = "积分：每十块抵一积分，积分可以在结账时抵扣，一积分抵扣一块钱（这个以后后台需要可设置话）")
    private Integer integral;


}

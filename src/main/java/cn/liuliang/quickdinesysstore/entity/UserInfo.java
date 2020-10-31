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
@TableName("t_user_info")
@ApiModel(value="UserInfo对象", description="")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身份类型：用户，会员")
    private String identityType;

    @ApiModelProperty(value = "优惠值：用户无优惠但有积分，会员有优惠（9折）而且还有积分")
    private Float discounts;

}

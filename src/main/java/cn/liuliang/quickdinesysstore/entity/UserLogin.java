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
@TableName("t_user_login")
@ApiModel(value="UserLogin对象", description="")
public class UserLogin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户姓名：用户回会员需要，游客无需需要")
    private String name;

    @ApiModelProperty(value = "电话号码：（登录账号）用户或会员需要（唯一），游客无需需要")
    private String phone;

    @ApiModelProperty(value = "密码：用户或会员可以登录，游客无需登录")
    private String password;

    @ApiModelProperty(value = "身份：关联身份信息表id")
    private Long userInfoId;

    @ApiModelProperty(value = "积分：每十块抵一积分，积分可以在结账时抵扣，一积分抵扣一块钱（这个以后后台需要可设置话）")
    private Integer integral;


}

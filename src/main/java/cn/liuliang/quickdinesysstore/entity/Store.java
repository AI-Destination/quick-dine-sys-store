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
@TableName("t_store")
@ApiModel(value="Store对象", description="")
public class Store extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店家名称（唯一）")
    private String storeName;

    @ApiModelProperty(value = "负责人名称")
    private String principalName;

    @ApiModelProperty(value = "负责人电话：登录账号")
    private String principalPhone;

    @ApiModelProperty(value = "登入密码")
    private String password;


}

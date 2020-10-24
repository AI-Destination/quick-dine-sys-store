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
@TableName("t_store_user")
@ApiModel(value="StoreUser对象", description="")
public class StoreUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店家id")
    private Long storeId;

    @ApiModelProperty(value = "用户id")
    private Long userId;


}

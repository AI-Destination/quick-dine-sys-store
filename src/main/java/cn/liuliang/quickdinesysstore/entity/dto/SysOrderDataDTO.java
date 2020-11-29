package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/11/27 - 8:41
 * @Description：
 */
@Data
@ApiModel(value="系统订单相关数据DTO", description="")
public class SysOrderDataDTO {

    @ApiModelProperty(value = "订单总数")
    private Integer[] orderTotal;

    @ApiModelProperty(value = "会员订单数")
    private Integer[] memberOrderNumber;

    @ApiModelProperty(value = "用户订单数")
    private Integer[] userOrderNumber;

    @ApiModelProperty(value = "游客订单数")
    private Integer[] touristOrderNumber;

}

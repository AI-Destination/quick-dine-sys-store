package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/11/27 - 8:32
 * @Description：
 */
@Data
@ApiModel(value="系统数据相关信息DTO", description="")
public class SysDataDTO {

    @ApiModelProperty(value = "系统客户数量相关信息DTO")
    private SysUserDataDTO sysUserDataDTO;

    @ApiModelProperty(value = "系统评论相关数据DTO")
    private SysDiscussDataDTO sysDiscussDataDTO;

    @ApiModelProperty(value = "系统交易相关数据DTO")
    private SysTransactionDataDTO sysTransactionDataDTO;

    @ApiModelProperty(value = "系统订单相关数据DTO")
    private SysOrderDataDTO sysOrderDataDTO;

}

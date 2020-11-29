package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/11/27 - 8:34
 * @Description：
 */
@Data
@ApiModel(value = "系统客户数量相关信息DTO", description = "")
public class SysUserDataDTO {

    @ApiModelProperty(value = "用户总数")
    private Integer[] userTotal;

    @ApiModelProperty(value = "会员数")
    private Integer[] memberNumber;

    @ApiModelProperty(value = "用户数")
    private Integer[] userNumber;

    @ApiModelProperty(value = "游客数")
    private Integer[] touristNumber;


}

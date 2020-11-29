package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/11/27 - 8:35
 * @Description：
 */
@Data
@ApiModel(value="系统评论相关数据DTO", description="")
public class SysDiscussDataDTO {

    @ApiModelProperty(value = "评论总数")
    private Integer[] discussTotal;

    @ApiModelProperty(value = "会员评论数")
    private Integer[] memberDiscussNumber;

    @ApiModelProperty(value = "用户评论数")
    private Integer[] userDiscussNumber;

    @ApiModelProperty(value = "游客评论数")
    private Integer[] touristDiscussNumber;


}

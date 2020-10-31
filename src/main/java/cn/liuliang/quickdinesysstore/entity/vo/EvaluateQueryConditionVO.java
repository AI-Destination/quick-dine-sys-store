package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/29 - 15:54
 * @Description：
 */
@Data
@ApiModel(value="评论查询条件vo", description="")
public class EvaluateQueryConditionVO {

    @ApiModelProperty(value = "评价人身份：游客，用户，会员")
    private String identityType;

    @ApiModelProperty(value = "标识：1，菜品口味；2，服务态度；3，店内环境；4，总体评价")
    private Integer per;

    @ApiModelProperty(value = "星值：1代表一星，依次类推，最高五星")
    private Integer perValue;

    @ApiModelProperty(value = "评价时间（格式：2020-02-20）")
    private String evaluateTime;
}

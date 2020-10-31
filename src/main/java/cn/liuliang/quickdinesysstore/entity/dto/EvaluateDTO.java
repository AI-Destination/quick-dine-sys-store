package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Data
@ApiModel(value="评价信息DTO", description="")
public class EvaluateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "评价人姓名：（游客就是游客）")
    private String evaluateName;

    @ApiModelProperty(value = "评价人账号：（游客就为空）")
    private String phone;

    @ApiModelProperty(value = "评价人身份：（游客就写游客）")
    private String identityType;

    @ApiModelProperty(value = "店家名称")
    private String storeName;

    @ApiModelProperty(value = "菜品口味：1代表一星，依次类推，最高五星")
    private Integer taste;

    @ApiModelProperty(value = "服务态度：1代表一星，依次类推，最高五星")
    private Integer attitude;

    @ApiModelProperty(value = "店内环境：1代表一星，依次类推，最高五星")
    private Integer environment;

    @ApiModelProperty(value = "总体评价：1代表一星，依次类推，最高五星")
    private Integer overallEvaluation;

    @ApiModelProperty(value = "意见")
    private String opinion;

    @ApiModelProperty(value = "评价时间")
    private Date createTime;
}

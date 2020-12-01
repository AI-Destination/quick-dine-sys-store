package cn.liuliang.quickdinesysstore.entity;

import cn.liuliang.quickdinesysstore.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
@TableName("t_evaluate")
@ApiModel(value="Evaluate对象", description="")
public class Evaluate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评价人姓名：（游客就是游客）")
    private String evaluateName;

    @ApiModelProperty(value = "评价人账号：（游客就为空）")
    private String phone;

    @ApiModelProperty(value = "评价人身份id")
    private Long userInfoId;

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
    private Date evaluateTime;


}

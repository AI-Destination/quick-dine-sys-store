package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 16:01
 * @Description：
 */
@Data
@ApiModel(value="员工级别信息vo", description="")
public class LevelVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "级别名称")
    private String levelName;

    @ApiModelProperty(value = "薪资")
    private BigDecimal compensation;
}

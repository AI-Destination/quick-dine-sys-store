package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 15:56
 * @Description：
 */
@Data
@EqualsAndHashCode()
@ApiModel(value="员工级别信息DTO", description="")
public class LevelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "级别名称")
    private String levelName;

    @ApiModelProperty(value = "薪资")
    private BigDecimal compensation;

}

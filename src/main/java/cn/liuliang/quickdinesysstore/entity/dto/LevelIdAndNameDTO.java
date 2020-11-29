package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/11/7 - 19:42
 * @Description：
 */
@Data
@EqualsAndHashCode()
@ApiModel(value="员工id和name信息DTO", description="")
public class LevelIdAndNameDTO {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "级别名称")
    private String levelName;
}

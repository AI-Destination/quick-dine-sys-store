package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 16:24
 * @Description：
 */
@Data
@ApiModel(value = "员工信息查询条件vo", description = "")
public class EmployeeQueryVO {

    @ApiModelProperty(value = "姓名")
    private String employeeName;

    @ApiModelProperty(value = "级别：关联级别表id")
    private Long levelId;

    @ApiModelProperty(value = "入职时间（格式：2020-01-10）")
    private String entryTime;
}

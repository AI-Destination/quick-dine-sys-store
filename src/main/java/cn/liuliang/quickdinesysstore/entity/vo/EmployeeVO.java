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
@ApiModel(value = "员工信息vo", description = "")
public class EmployeeVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String employeeName;

    @ApiModelProperty(value = "级别：关联级别表id")
    private Long levelId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "入职时间")
    private String entryTime;
}

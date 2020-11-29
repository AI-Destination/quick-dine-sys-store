package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 16:32
 * @Description：
 */
@Data
@ApiModel(value = "员工详细信息DTO", description = "")
public class EmployeeDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String employeeName;

    @ApiModelProperty(value = "级别：关联级别表id")
    private Long levelId;

    @ApiModelProperty(value = "级别信息对象")
    private LevelDTO levelDTO;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "入职时间")
    private Date entryTime;
}

package cn.liuliang.quickdinesysstore.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 16:24
 * @Description：
 */
@Data
@ApiModel(value = "员工信息DTO", description = "")
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String employeeName;

    @ApiModelProperty(value = "级别：关联级别表id")
    private Long levelId;

    @ApiModelProperty(value = "级别名称")
    private String levelName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "入职时间")
    private Date entryTime;
}

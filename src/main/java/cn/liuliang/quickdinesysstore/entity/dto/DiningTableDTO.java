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
@ApiModel(value="餐桌信息DTO", description="")
public class DiningTableDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "桌号：不为空，唯一")
    private String diningTableNumber;

    @ApiModelProperty(value = "餐桌名称：特色名称，有利于店面文怀")
    private String diningTableName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}

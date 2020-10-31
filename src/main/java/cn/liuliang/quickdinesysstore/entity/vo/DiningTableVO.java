package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/29 - 17:11
 * @Description：
 */
@Data
@ApiModel(value = "餐桌信息vo", description = "")
public class DiningTableVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "桌号：不为空，唯一")
    private String diningTableNumber;

    @ApiModelProperty(value = "餐桌名称：特色名称，有利于店面文怀")
    private String diningTableName;

}

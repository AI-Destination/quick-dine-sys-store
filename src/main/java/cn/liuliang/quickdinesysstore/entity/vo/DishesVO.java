package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/29 - 11:47
 * @Description：
 */
@Data
@ApiModel(value = "菜品信息vo", description = "")
public class DishesVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "菜名：唯一")
    private String dishesName;

    @ApiModelProperty(value = "所属类别：什么类型的菜，关联下表（菜品分类表）id")
    private Long dishesTypeId;

    @ApiModelProperty(value = "简介：菜品的描述")
    private String briefIntroduction;

    @ApiModelProperty(value = "图片：存储图片的url访问地址")
    private String imageUrl;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;


}

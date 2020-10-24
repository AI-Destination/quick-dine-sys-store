package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 15:02
 * @Description：
 */
@Data
@EqualsAndHashCode()
@ApiModel(value="DishesVO对象", description="")
public class DishesVO{

    private static final long serialVersionUID = 1L;

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

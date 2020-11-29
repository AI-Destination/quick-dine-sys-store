package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/10/30 - 9:34
 * @Description：
 */
@Data
@ApiModel(value="所点菜品信息DTO", description="")
public class AlreadyOrderDishesDTO implements Serializable {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "菜Id：关联菜品表，根据这个菜品id可以查到菜品所有信息")
    private Long dishesId;

    @ApiModelProperty(value = "图片：存储图片的url访问地址")
    private String imageUrl;

    @ApiModelProperty(value = "菜名：唯一")
    private String dishesName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "数量")
    private Integer number;

    @ApiModelProperty(value = "合计：价格 * 数量")
    private BigDecimal sumPrice;

}

package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/28 - 19:30
 * @Description：
 */
@Data
@ApiModel(value="菜品查询条件vo", description="")
public class DishesQueryConditionVO {

    @ApiModelProperty(value = "菜名：唯一")
    private String dishesName;

    @ApiModelProperty(value = "菜品类别")
    private String dishesTypeName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "创建时间：格式（2020-10-10）")
    private String createTime;

}

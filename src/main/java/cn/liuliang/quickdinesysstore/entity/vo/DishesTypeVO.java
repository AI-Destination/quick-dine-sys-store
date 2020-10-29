package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/28 - 17:33
 * @Description：
 */
@Data
@ApiModel(value="菜品分类vo", description="")
public class DishesTypeVO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "菜名：唯一")
    private String dishesName;

}

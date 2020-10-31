package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.vo
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 15:02
 * @Description：
 */
@Data
@EqualsAndHashCode()
@ApiModel(value="菜品信息DTO", description="")
public class DishesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "图片：存储图片的url访问地址")
    private String imageUrl;

    @ApiModelProperty(value = "菜名：唯一")
    private String dishesName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "所属类别id")
    private Long dishesTypeId;

    @ApiModelProperty(value = "所属类别名称")
    private String dishesTypeName;

    @ApiModelProperty(value = "简介：菜品的描述")
    private String briefIntroduction;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}

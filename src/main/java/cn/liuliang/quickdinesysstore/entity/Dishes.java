package cn.liuliang.quickdinesysstore.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import cn.liuliang.quickdinesysstore.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_dishes")
@ApiModel(value="Dishes对象", description="")
public class Dishes extends BaseEntity {

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

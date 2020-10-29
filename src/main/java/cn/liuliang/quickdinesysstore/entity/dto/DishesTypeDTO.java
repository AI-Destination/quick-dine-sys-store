package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/10/28 - 16:54
 * @Description：
 */
@Data
@ApiModel(value="菜品种类dto", description="")
public class DishesTypeDTO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "分类名称：唯一")
    private String typeName;
}

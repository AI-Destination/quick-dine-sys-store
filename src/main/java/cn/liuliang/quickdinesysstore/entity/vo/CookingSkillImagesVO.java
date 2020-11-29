package cn.liuliang.quickdinesysstore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Data
@ApiModel(value="厨艺秀信息VO", description="")
public class CookingSkillImagesVO{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "照片url")
    private String imageUrl;


}

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
@TableName("t_level")
@ApiModel(value="Level对象", description="")
public class Level extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "级别名称")
    private String levelName;

    @ApiModelProperty(value = "薪资")
    private BigDecimal compensation;


}

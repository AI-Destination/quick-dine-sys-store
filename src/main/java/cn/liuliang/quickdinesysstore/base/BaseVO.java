package cn.liuliang.quickdinesysstore.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.base
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 15:46
 * @Description： 公共查询条件
 */
@Data
public class BaseVO {

    @ApiModelProperty(value = "店家名称")
    private String storeName;

}

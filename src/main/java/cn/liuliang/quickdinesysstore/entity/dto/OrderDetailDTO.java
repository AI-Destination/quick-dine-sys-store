package cn.liuliang.quickdinesysstore.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Package： cn.liuliang.quickdinesysstore.entity.dto
 * @Author： liuliang
 * @CreateTime： 2020/10/30 - 9:31
 * @Description：
 */
@Data
@ApiModel(value="订单详情信息DTO", description="")
public class OrderDetailDTO implements Serializable {

    @ApiModelProperty(value = "订单基本信息DTO对象")
    private OrderDTO orderDTO;

    @ApiModelProperty(value = "所点菜品信息DTO列表")
    List<AlreadyOrderDishesDTO> alreadyOrderDishesDTOList;

}

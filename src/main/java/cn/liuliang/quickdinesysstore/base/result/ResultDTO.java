package cn.liuliang.quickdinesysstore.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package： cn.liuliang.quickdinesysstore.base.result
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 13:51
 * @Description：
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class ResultDTO {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public ResultDTO(){}

    public static ResultDTO success(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        resultDTO.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultDTO.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return resultDTO;
    }

    public static ResultDTO success(String key, Object value){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        resultDTO.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultDTO.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        resultDTO.data.put(key,value);
        return resultDTO;
    }

    public static ResultDTO error(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        resultDTO.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        resultDTO.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return resultDTO;
    }

    public static ResultDTO setResult(ResultCodeEnum resultCodeEnum) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(resultCodeEnum.getSuccess());
        resultDTO.setCode(resultCodeEnum.getCode());
        resultDTO.setMessage(resultCodeEnum.getMessage());
        return resultDTO;
    }


    public ResultDTO success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResultDTO message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultDTO code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultDTO data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResultDTO data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}

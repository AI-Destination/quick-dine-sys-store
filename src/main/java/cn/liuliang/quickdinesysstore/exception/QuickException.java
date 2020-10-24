package cn.liuliang.quickdinesysstore.exception;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import lombok.Data;

/**
 * @Package： cn.liuliang.quickdinesysstore.exception
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 15:27
 * @Description：
 */
@Data
public class QuickException extends RuntimeException {

    private Integer code;

    public QuickException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public QuickException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GuLiException{" +
                "code=" + code +
                "，message=" + this.getMessage() +
                '}';
    }
}

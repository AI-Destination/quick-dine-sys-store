package cn.liuliang.quickdinesysstore.handler;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package： cn.liuliang.quickdinesysstore.handler
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 15:24
 * @Description：
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO error(Exception e) {
        log.error("error", e);
        return ResultDTO.error();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public ResultDTO error(BadSqlGrammarException e) {
        log.error("error", e);
        return ResultDTO.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultDTO error(HttpMessageNotReadableException e) {
        log.error("error", e);
        return ResultDTO.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler(QuickException.class)
    @ResponseBody
    public ResultDTO error(QuickException e) {
        log.error("error", e);
        return ResultDTO.error().message(e.getMessage()).code(e.getCode());
    }

}

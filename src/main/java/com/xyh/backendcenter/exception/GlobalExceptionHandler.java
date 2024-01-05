package com.xyh.backendcenter.exception;
import cn.dev33.satoken.exception.NotLoginException;
import com.xyh.backendcenter.common.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Tag(name = "全局异常处理类")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        log.error("exception",e);
        return Result.fail();
    }

    /**
     * 登录验证
     * @param e
     * @return
     */
    @ExceptionHandler(NotLoginException.class)
    public Result unLoginHandler(NotLoginException e){
        Result<Object> result = new Result<>();
        result.setCode(e.getCode());
        result.message(e.getMessage());
        return result;
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    public Result backendException(BackendException e){
        return Result.build(e.getCode(),e.getMessage());
    }

}

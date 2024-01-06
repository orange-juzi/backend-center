package com.xyh.backendcenter.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.crypto.digest.DigestUtil;
import com.xyh.backendcenter.common.Result;
import com.xyh.backendcenter.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Tag(name = "全局异常处理类")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        //处理后端验证失败产生的异常
        if (e instanceof MethodArgumentNotValidException exception) {
            log.error("执行异常", e);
//            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            return Result.build(500, exception.getBindingResult().getFieldError().getDefaultMessage(), null);
            //处理自自定义异常
        } else if (e instanceof BackendException exception) {
            log.error("执行异常", e);
//            BackendException exception = (BackendException) e;
            return Result.build(exception.getCode(), exception.getMessage(), null);
        } else {
            log.error("执行异常", e);
            return Result.build(ResultCodeEnum.FAIL, null);
        }
    }

    /**
     * 登录验证
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotLoginException.class)
    public Result<?> unLoginHandler(NotLoginException e) {
        Result<?> result = new Result<>();
        result.setCode(e.getCode());
        result.setMsg(e.getMessage());
        return result;
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(BackendException.class)
//    public Result backendException(BackendException e) {
//        return Result.build(e.getCode(), e.getMessage());
//    }

}

package com.xyh.backendcenter.exception;


import com.xyh.backendcenter.common.ResultCodeEnum;
import lombok.Data;


@Data
public class BackendException extends RuntimeException {

    private Integer code ;          // 错误状态码
    private String message ;        // 错误消息

    private ResultCodeEnum resultCodeEnum ;     // 封装错误状态码和错误消息

    public BackendException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum ;
        this.code = resultCodeEnum.getCode() ;
        this.message = resultCodeEnum.getMsg();
    }

    public BackendException(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}
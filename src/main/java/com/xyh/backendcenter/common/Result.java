package com.xyh.backendcenter.common;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 全局统一返回结果类
 */
@Data
@Schema(description = "全局统一返回结果")
public class Result<T> {

    @Schema(description = "返回码")
    private Integer code;

    @Schema(description = "返回消息")
    private String msg;

    @Schema(description = "返回数据")
    private T data;

    public Result() {
    }

//    protected static <T> Result<T> build(T data) {
//        Result<T> result = new Result<T>();
//        if (data != null)
//            result.setData(data);
//        return result;
//    }

    public static <T> Result<T> build(ResultCodeEnum resultCodeEnum, T data) {
        return build(resultCodeEnum.getCode(), resultCodeEnum.getMsg(), data);
    }

//    public static <T> Result<T> build(Integer code, String message) {
//        Result<T> result = build(null);
//        result.setCode(code);
//        result.setMsg(message);
//        return result;
//    }

    public static <T> Result<T> build(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(message);
        result.setData(data);
        return result;
    }

//    public static<T> Result<T> ok(){
//        return Result.ok(null);
//    }


//    public static<T> Result<T> ok(T data){
//        Result<T> result = build(data);
//        return build(data, ResultCodeEnum.SUCCESS);
//    }

//    public static<T> Result<T> fail(){
//        return Result.fail(null);
//    }


//    public static<T> Result<T> fail(T data){
//        Result<T> result = build(data);
//        return build(data, ResultCodeEnum.FAIL);
//    }

//    public Result<T> message(String msg){
//        this.setMsg(msg);
//        return this;
//    }
//
//    public Result<T> code(Integer code){
//        this.setCode(code);
//        return this;
//    }

}

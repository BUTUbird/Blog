package com.butu.blog.common.exception;

import com.butu.blog.common.lang.Result;
import com.butu.blog.common.lang.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author BUTUbird
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handle(RuntimeException e){
        log.error("运行时异常：--------------{}", e);
        return Result.error().codeAndMessage(ResultInfo.GLOBAL_ERROR).data("error", e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handle(ShiroException e){
        log.error("Shiro异常：--------------{}", e);
        return Result.error().codeAndMessage(ResultInfo.GLOBAL_ERROR).data("error", e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handle(MethodArgumentNotValidException e){
        log.error("实体校验异常：--------------{}", e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();

        return Result.error().codeAndMessage(ResultInfo.GLOBAL_ERROR).data("error",objectError.getDefaultMessage());

    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handle(IllegalArgumentException e){
        log.error("断言异常：--------------{}", e);
        return Result.error().codeAndMessage(ResultInfo.GLOBAL_ERROR).data("error",e.getMessage());

    }
}

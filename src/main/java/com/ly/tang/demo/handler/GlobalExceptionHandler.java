package com.ly.tang.demo.handler;

import com.ly.tang.demo.response.wrapper.Wrapper;
import com.ly.tang.demo.response.wrapper.WrapperMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tangmingjian 2018-04-29 上午10:49
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Wrapper exception(Exception e){
        log.error("System error:{}",e.getMessage(),e);
        return WrapperMapper.error();
    }

}

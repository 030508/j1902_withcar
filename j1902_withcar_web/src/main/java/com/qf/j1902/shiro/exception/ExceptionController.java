package com.qf.j1902.shiro.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/6/28 0028.
 */
@ControllerAdvice //标识为控制层拦截器
public class ExceptionController {
    @ExceptionHandler(value=Exception.class)
    public String defaultErrorHandler(HttpServletRequest request,Exception e){
        return "unauth";
    }
}

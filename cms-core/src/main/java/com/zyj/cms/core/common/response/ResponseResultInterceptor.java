package com.zyj.cms.core.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
@Component
@Slf4j
public class ResponseResultInterceptor implements HandlerInterceptor {
    public static final String REQUEST_RESULT = "RESPONSE-RESULT";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class)){
                request.setAttribute(REQUEST_RESULT, clazz.getAnnotation(ResponseResult.class));
            }else if (method.isAnnotationPresent(ResponseResult.class)){
                request.setAttribute(REQUEST_RESULT,method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}

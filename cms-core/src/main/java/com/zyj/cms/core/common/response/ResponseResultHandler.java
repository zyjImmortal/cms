package com.zyj.cms.core.common.response;

import com.zyj.cms.core.common.util.RequestContextUtil;
import com.zyj.cms.util.commons.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
@ControllerAdvice
@Slf4j
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 是否支持响应体转换，这里是要被@ResponseResult标记的请求才会进行转换
     * @param returnType
     * @param converterType
     * @return
     */
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = RequestContextUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.REQUEST_RESULT);
        return responseResultAnn != null;
    }

    /**
     * 对响应体进行重写
     * @param body
     * @param returnType
     * @param mediaType
     * @param aClass
     * @param request
     * @param response
     * @return
     */
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        ResponseResult responseResultAnna = (ResponseResult) RequestContextUtil.getRequest()
                .getAttribute(ResponseResultInterceptor.REQUEST_RESULT);
        Class<? extends Response> resultClazz = responseResultAnna.value();
        if (resultClazz.isAssignableFrom(PlatformResponse.class)) {
            if (body instanceof DefaultErrorResponse) {
                DefaultErrorResponse defaultErrorResult = (DefaultErrorResponse) body;
                return PlatformResponse.builder()
                        .code(defaultErrorResult.getCode())
                        .message(defaultErrorResult.getMessage())
                        .data(defaultErrorResult.getErrors())
                        .build();
            } else if (body instanceof String) {
                return JsonUtil.object2Json(PlatformResponse.success(body));
            }
            return PlatformResponse.success(body);
        }
        return body;
    }
}

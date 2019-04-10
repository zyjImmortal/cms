package com.zyj.cms.core.common.handler;

import com.zyj.cms.core.common.bo.ParameterInvalidItem;
import com.zyj.cms.core.common.exceptions.BusinessException;
import com.zyj.cms.core.common.response.DefaultErrorResponse;
import com.zyj.cms.core.common.response.ResponseCodeEnum;
import com.zyj.cms.core.common.util.ParameterInvalidItemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
public class BaseGlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseGlobalExceptionHandler.class);

    /**
     * 违反约束异常
     * @param e
     * @param request
     * @return
     */
    protected DefaultErrorResponse handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
        LOGGER.info("handleConstrainViolationException start, uri:{}, caused by:",request.getRequestURI(), e);
        List<ParameterInvalidItem> parameterInvalidItemList = ParameterInvalidItemUtil.convertCVSetToParameterInvalidItemList(e.getConstraintViolations());
        return DefaultErrorResponse.failure(ResponseCodeEnum.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItemList);
    }

    /**
     * 处理验证参数封装错误时异常
     * @param e
     * @param request
     * @return
     */
    protected DefaultErrorResponse handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request){
        LOGGER.info("handleConstrainViolationException start, uri:{}, caused by:", request.getRequestURI(), e);
        return DefaultErrorResponse.failure(ResponseCodeEnum.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 使用@Validated注解时，参数验证错误异常
     * @param e
     * @param request
     * @return
     */
    protected DefaultErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        LOGGER.info("handleMethodArgumentNotValidException start,uri:{}, caused by:", request.getRequestURI(), e);
        List<ParameterInvalidItem> parameterInvalidItems = ParameterInvalidItemUtil.convertBindingResultToMapParameterInvalidItemList(e.getBindingResult());
        return DefaultErrorResponse.failure(ResponseCodeEnum.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItems);
    }

    /**
     * 处理参数绑定时异常
     * @param e
     * @param request
     * @return
     */
    protected DefaultErrorResponse handleBindException(BindException e, HttpServletRequest request){
        LOGGER.info("handleBindException start, uri:{}, caused by:",request.getRequestURI(), e);
        List<ParameterInvalidItem> parameterInvalidItems = ParameterInvalidItemUtil.convertBindingResultToMapParameterInvalidItemList(e.getBindingResult());
        return DefaultErrorResponse.failure(ResponseCodeEnum.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItems);
    }

    protected ResponseEntity<DefaultErrorResponse> handleBusinessException(BusinessException e, HttpServletRequest request){
        LOGGER.info("handleBusinessException start, uri:{}, exception:{}, caused by: {}", request.getRequestURI(), e.getClass(), e.getMessage());
        DefaultErrorResponse defaultErrorResult = DefaultErrorResponse.failure(e);
        return ResponseEntity
                .status(HttpStatus.valueOf(defaultErrorResult.getStatus()))
                .body(defaultErrorResult);
    }

    protected DefaultErrorResponse handleThrowable(Throwable e, HttpServletRequest request) {
        LOGGER.error("handleThrowable start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResponse.failure(ResponseCodeEnum.SYSTEM_INNER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

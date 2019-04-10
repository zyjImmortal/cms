package com.zyj.cms.core.common.response;

import com.zyj.cms.core.common.exceptions.BusinessException;
import com.zyj.cms.core.common.exceptions.BusinessExceptionEnum;
import com.zyj.cms.core.common.util.RequestContextUtil;
import com.zyj.cms.util.commons.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author zhouyajun
 * @date 2019/4/9
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorResponse implements Response {
    private static final long serialVersionUID = 874200365941306385L;
    /**
     * HTTP响应状态码 {@link HttpStatus}
     */
    private Integer status;

    /**
     * HTTP响应状态码的英文提示
     */
    private String error;

    /**
     * 异常堆栈的精简信息
     */
    private String message;

    /**
     * 我们系统内部自定义的返回值编码，{@link ResponseCodeEnum} 它是对错误更加详细的编码
     * <p>
     * 备注：spring boot默认返回异常时，该字段为null
     */
    private Integer code;

    /**
     * 调用接口路径
     */
    private String path;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常的错误传递的数据
     */
    private Object errors;

    /**
     * 时间戳
     */
    private Date timestamp;

    public static DefaultErrorResponse failure(ResponseCodeEnum resultCode, Throwable e, HttpStatus httpStatus, Object errors) {
        DefaultErrorResponse result = DefaultErrorResponse.failure(resultCode, e, httpStatus);
        result.setErrors(errors);
        return result;
    }

    public static DefaultErrorResponse failure(ResponseCodeEnum resultCode, Throwable e, HttpStatus httpStatus) {
        DefaultErrorResponse result = new DefaultErrorResponse();
        result.setCode(resultCode.code());
        result.setMessage(resultCode.message());
        result.setStatus(httpStatus.value());
        result.setError(httpStatus.getReasonPhrase());
        result.setException(e.getClass().getName());
        String path = RequestContextUtil.getRequest().getRequestURI();
        result.setPath(path);
        result.setTimestamp(new Date());
        return result;
    }

    public static DefaultErrorResponse failure(BusinessException e) {
        BusinessExceptionEnum ee = BusinessExceptionEnum.getByEClass(e.getClass());
        if (ee != null) {
            return DefaultErrorResponse.failure(ee.getResultCode(), e, ee.getHttpStatus(), e.getData());
        }

        DefaultErrorResponse defaultErrorResult = DefaultErrorResponse.failure(
                e.getResultCode() == null ? ResponseCodeEnum.SUCCESS : e.getResultCode(), e, HttpStatus.OK, e.getData());
        if (StringUtil.isNotEmpty(e.getMessage())) {
            defaultErrorResult.setMessage(e.getMessage());
        }
        return defaultErrorResult;
    }
}

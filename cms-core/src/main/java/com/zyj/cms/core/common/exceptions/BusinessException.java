package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;
import com.zyj.cms.util.commons.StringUtil;
import lombok.Data;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
@Data
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 194906846739586856L;

    protected String code;

    protected String message;

    protected ResponseCodeEnum resultCode;

    protected Object data;

    public BusinessException() {
        BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.getResultCode();
            code = exceptionEnum.getResultCode().code().toString();
            message = exceptionEnum.getResultCode().message();
        }

    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        this.message = StringUtil.formatIfArgs(format, "{}", objects);
    }

    public BusinessException(ResponseCodeEnum resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public BusinessException(ResponseCodeEnum resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code().toString();
        this.message = resultCode.message();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResponseCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

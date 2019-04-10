package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;

/**
 * @author zhouyajun
 * @date 2019/3/25
 */
public class MethodNotAllowException extends BusinessException {

    private static final long serialVersionUID = -3813290937049524713L;

    public MethodNotAllowException() {
        super();
    }

    public MethodNotAllowException(Object data) {
        super.data = data;
    }

    public MethodNotAllowException(ResponseCodeEnum resultCode) {
        super(resultCode);
    }

    public MethodNotAllowException(ResponseCodeEnum resultCode, Object data) {
        super(resultCode, data);
    }

    public MethodNotAllowException(String msg) {
        super(msg);
    }

    public MethodNotAllowException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }


}

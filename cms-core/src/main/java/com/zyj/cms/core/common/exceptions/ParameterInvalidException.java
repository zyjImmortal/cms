package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;

/**
 * 参数无效
 * @author zhouyajun
 * @date 2019/3/25
 */
public class ParameterInvalidException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public ParameterInvalidException() {
        super();
    }

    public ParameterInvalidException(Object data) {
        super();
        super.data = data;
    }

    public ParameterInvalidException(ResponseCodeEnum resultCode) {
        super(resultCode);
    }

    public ParameterInvalidException(ResponseCodeEnum resultCode, Object data) {
        super(resultCode, data);
    }

    public ParameterInvalidException(String msg) {
        super(msg);
    }

    public ParameterInvalidException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}

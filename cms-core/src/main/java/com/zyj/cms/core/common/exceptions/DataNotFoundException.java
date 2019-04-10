package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;

/**
 * @author zhouyajun
 * @date 2019/3/25
 */
public class DataNotFoundException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public DataNotFoundException(ResponseCodeEnum resultCode) {
        super(resultCode);
    }

    public DataNotFoundException(ResponseCodeEnum resultCode, Object data) {
        super(resultCode, data);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}

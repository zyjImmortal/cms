package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;

/**
 * @author zhouyajun
 * @date 2019/3/27
 */
public class UserNotFoundException extends BusinessException {
    private static final long serialVersionUID = 3721036867889297081L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public UserNotFoundException(ResponseCodeEnum resultCode) {
        super(resultCode);
    }

    public UserNotFoundException(ResponseCodeEnum resultCode, Object data) {
        super(resultCode, data);
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(String msg, Object... objects) {
        super(msg, objects);
    }
}

package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;

/**
 * @author zhouyajun
 * @date 2019/3/25
 */
public class PermissionForbiddenException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public PermissionForbiddenException() {
        super();
    }

    public PermissionForbiddenException(Object data) {
        super.data = data;
    }

    public PermissionForbiddenException(ResponseCodeEnum resultCode) {
        super(resultCode);
    }

    public PermissionForbiddenException(ResponseCodeEnum resultCode, Object data) {
        super(resultCode, data);
    }

    public PermissionForbiddenException(String msg) {
        super(msg);
    }

    public PermissionForbiddenException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}

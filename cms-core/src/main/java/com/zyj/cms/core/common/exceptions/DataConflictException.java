package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;

/**
 * 数据已存在异常
 * @author zhouyajun
 * @date 2019/3/25
 */
public class DataConflictException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public DataConflictException() {
        super();
    }

    public DataConflictException(Object data) {
        super.data = data;
    }

    public DataConflictException(ResponseCodeEnum resultCode) {
        super(resultCode);
    }

    public DataConflictException(ResponseCodeEnum resultCode, Object data) {
        super(resultCode, data);
    }

    public DataConflictException(String msg) {
        super(msg);
    }

    public DataConflictException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }


}

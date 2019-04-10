package com.zyj.cms.core.common.exceptions;

/**
 * @author zhouyajun
 * @date 2019/3/25
 */
public class UserNotLoginException extends BusinessException {

    private static final long serialVersionUID = -1879503946782379204L;

    public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }

    public UserNotLoginException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}

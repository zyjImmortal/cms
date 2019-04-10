package com.zyj.cms.core.common.exceptions;

import com.zyj.cms.core.common.response.ResponseCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
public enum  BusinessExceptionEnum {
    /**
     * 无效参数
     */
    PARAMETER_INVALID(ParameterInvalidException.class, HttpStatus.BAD_REQUEST, ResponseCodeEnum.PARAM_IS_INVALID),

    /**
     * 数据未找到
     */
    NOT_FOUND(DataNotFoundException.class, HttpStatus.NOT_FOUND, ResponseCodeEnum.RESULE_DATA_NONE),

    /**
     * 用户未找到
     */
    USER_NOT_FOUND(UserNotFoundException.class, HttpStatus.NOT_FOUND, ResponseCodeEnum.USER_NOT_EXIST),

    /**
     * 接口方法不允许
     */
    METHOD_NOT_ALLOWED(MethodNotAllowException.class, HttpStatus.METHOD_NOT_ALLOWED, ResponseCodeEnum.INTERFACE_ADDRESS_INVALID),

    /**
     * 数据已存在
     */
    CONFLICT(DataConflictException.class, HttpStatus.CONFLICT, ResponseCodeEnum.DATA_ALREADY_EXISTED),

    /**
     * 用户未登录
     */
    UNAUTHORIZED(UserNotLoginException.class, HttpStatus.UNAUTHORIZED, ResponseCodeEnum.USER_NOT_LOGGED_IN),

    /**
     * 无访问权限
     */
    FORBIDDEN(PermissionForbiddenException.class, HttpStatus.FORBIDDEN, ResponseCodeEnum.PERMISSION_NO_ACCESS),

    /**
     * 远程访问时错误
     */
    REMOTE_ACCESS_ERROR(RemoteAccessException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResponseCodeEnum.INTERFACE_OUTTER_INVOKE_ERROR),

    /**
     * 系统内部错误
     */
    INTERNAL_SERVER_ERROR(InternalServerException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResponseCodeEnum.SYSTEM_INNER_ERROR);

    private Class<? extends BusinessException> eClass;

    private HttpStatus httpStatus;

    private ResponseCodeEnum resultCode;

    BusinessExceptionEnum(Class<? extends BusinessException> eClass, HttpStatus httpStatus, ResponseCodeEnum resultCode) {
        this.eClass = eClass;
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
    }

    public Class<? extends BusinessException> getEClass() {
        return eClass;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResponseCodeEnum getResultCode() {
        return resultCode;
    }

    public static boolean isSupportHttpStatus(int httpStatus) {
        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (exceptionEnum.httpStatus.value() == httpStatus) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSupportException(Class<?> z) {
        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (exceptionEnum.eClass.equals(z)) {
                return true;
            }
        }

        return false;
    }

    public static BusinessExceptionEnum getByHttpStatus(HttpStatus httpStatus) {
        if (httpStatus == null) {
            return null;
        }

        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (httpStatus.equals(exceptionEnum.httpStatus)) {
                return exceptionEnum;
            }
        }

        return null;
    }

    public static BusinessExceptionEnum getByEClass(Class<? extends BusinessException> eClass) {
        if (eClass == null) {
            return null;
        }

        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (eClass.equals(exceptionEnum.eClass)) {
                return exceptionEnum;
            }
        }

        return null;
    }
}

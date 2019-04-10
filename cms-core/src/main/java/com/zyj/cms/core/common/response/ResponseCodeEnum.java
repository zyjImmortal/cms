package com.zyj.cms.core.common.response;

/**
 * @author zhouyajun
 * @date 2019/4/9
 */
public enum ResponseCodeEnum {

    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功"),

    /**
     * 服务器错误
     */
    SERVER_ERROR(500, "服务器错误"),

    /**
     *参数相关
     */
    PARAM_IS_INVALID(2001, "参数错误"),
    PARAM_IS_BANK(2002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(2003, "参数类型错误"),
    PARAM_NOT_COMPLETE(2004, "参数无效"),

    /**
     * 用户相关状态妈3
     */
    USER_NOT_FOUND(1001, "用户未找到"),
    USER_NOT_LOGGED_IN(1002, "用户未登录"),
    USER_LOGIN_ERROR(1003, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(1003, "账号已被禁用"),
    USER_NOT_EXIST(1004, "用户不存在"),
    USER_HAS_EXISTED(1005, "用户已存在"),

    /**
     *  业务错误：30001-39999
     */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(3001, "某业务出现问题"),

    /**
     * 系统错误：40001-49999
     */
    SYSTEM_INNER_ERROR(4001, "系统繁忙，请稍后重试"),

    /**
     * 数据错误：50001-599999
     */
    RESULE_DATA_NONE(5001, "数据未找到"),
    DATA_IS_WRONG(5002, "数据有误"),
    DATA_ALREADY_EXISTED(5003, "数据已存在"),

    /**
     * 接口错误：60001-69999
     */
    INTERFACE_INNER_INVOKE_ERROR(6001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(6002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(6003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(6004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(6005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(6006, "接口负载过高"),

    /**
     * 权限错误：70001-79999
     */
    PERMISSION_NO_ACCESS(7001, "无访问权限");

    private Integer code;
    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据您错误名称获取错误对应message
     *
     * @param name 错误名称
     * @return message
     */
    public String getMessage(String name) {
        for (ResponseCodeEnum item : ResponseCodeEnum.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return null;
    }

    /**
     * 根据您错误名称获取错误对用code
     *
     * @param name 错误名称
     * @return 错误码
     */
    public Integer getCode(String name) {
        for (ResponseCodeEnum item : ResponseCodeEnum.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}

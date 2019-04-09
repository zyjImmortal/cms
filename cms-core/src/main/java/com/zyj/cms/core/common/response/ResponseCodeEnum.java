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
     * 用户相关状态妈3
     */
    USER_NOT_FOUND(1001, "用户未找到");

    private Integer code;
    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取错误对应message
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
     * 获取错误对用code
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
}

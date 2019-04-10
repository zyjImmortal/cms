package com.zyj.cms.core.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回相应对象
 *
 * @author zhouyajun
 * @date 2019/4/9
 */
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PlatformResponse implements Response {
    private static final long serialVersionUID = 874200365941306385L;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    private void setResponseCode(ResponseCodeEnum responseCode) {
        this.code = responseCode.code();
        this.message = responseCode.message();
    }

    public static PlatformResponse success() {
        PlatformResponse response = new PlatformResponse();
        response.setResponseCode(ResponseCodeEnum.SUCCESS);
        return response;
    }

    public static PlatformResponse success(Object data) {
        PlatformResponse response = new PlatformResponse();
        response.setResponseCode(ResponseCodeEnum.SUCCESS);
        response.setData(data);
        return response;
    }

    public static PlatformResponse failure(String message) {
        PlatformResponse response = new PlatformResponse();
        response.setCode(ResponseCodeEnum.PARAM_IS_INVALID.code());
        response.setMessage(message);
        return response;
    }

    public static PlatformResponse failure(ResponseCodeEnum responseCodeEnum, Object data) {
        PlatformResponse platformResponse = new PlatformResponse();
        platformResponse.setResponseCode(responseCodeEnum);
        platformResponse.setData(data);
        return platformResponse;
    }

    public static PlatformResponse failure(Integer code, String message, Object data) {
        PlatformResponse platformResponse = new PlatformResponse();
        platformResponse.setCode(code);
        platformResponse.setMessage(message);
        platformResponse.setData(data);
        return platformResponse;
    }

    public static PlatformResponse failure(ResponseCodeEnum responseCodeEnum) {
        PlatformResponse platformResponse = new PlatformResponse();
        platformResponse.setResponseCode(responseCodeEnum);
        return platformResponse;
    }
}

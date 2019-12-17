package com.zyj.cms.core.service.geek.codedesign.orientobject;

/**
 * @author : zhouyajun
 * @date : 2019-12-16
 */
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    /**
     * full url里包含token，请求参数
     *
     * @param url
     * @return
     */
    public static ApiRequest createFromFullUrl(String url) {
        return null;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

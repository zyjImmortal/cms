package com.zyj.cms.core.service.geek.codedesign.metrics;

/**
 * @author : zhouyajun
 * @date : 2020-02-16
 */
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;

    public String getApiName() {
        return apiName;
    }

    public RequestInfo setApiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public RequestInfo setResponseTime(double responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public RequestInfo setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}

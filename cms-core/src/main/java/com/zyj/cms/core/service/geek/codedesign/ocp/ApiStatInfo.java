package com.zyj.cms.core.service.geek.codedesign.ocp;

/**
 * Author: zhouyajun
 * Date: 2019-12-17
 */
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;

    public String getApi() {
        return api;
    }

    public ApiStatInfo setApi(String api) {
        this.api = api;
        return this;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public ApiStatInfo setRequestCount(long requestCount) {
        this.requestCount = requestCount;
        return this;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public ApiStatInfo setErrorCount(long errorCount) {
        this.errorCount = errorCount;
        return this;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public ApiStatInfo setDurationOfSeconds(long durationOfSeconds) {
        this.durationOfSeconds = durationOfSeconds;
        return this;
    }
}

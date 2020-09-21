package com.zyj.cms.core.service.geek.codedesign.metrics;

import java.util.List;
import java.util.Map;

/**
 * @author: zhouyajun
 * @date: 2020-02-16
 */
public class RestMetricsStorage implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getReqeustInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}

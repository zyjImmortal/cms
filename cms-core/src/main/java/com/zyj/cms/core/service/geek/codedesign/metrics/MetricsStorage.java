package com.zyj.cms.core.service.geek.codedesign.metrics;

import java.util.List;
import java.util.Map;

/**
 * @author: zhouyajun
 * @date: 2020-02-16
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);
    List<RequestInfo> getReqeustInfos(String apiName, long startTimeInMillis, long endTimeInMillis);
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}

package com.zyj.cms.core.service.geek.codedesign.metrics;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : zhouyajun
 * @date : 2020-02-16
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage;

    public MetricsCollector(MetricsStorage metricsStorage){
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo){
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}

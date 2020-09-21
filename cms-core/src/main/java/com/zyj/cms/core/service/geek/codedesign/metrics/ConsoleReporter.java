package com.zyj.cms.core.service.geek.codedesign.metrics;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhouyajun
 * @date: 2020-02-16
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;
    public ConsoleReporter (MetricsStorage metricsStorage, ScheduledExecutorService executor){
        this.metricsStorage = metricsStorage;
        this.executor = executor;
    }

    /**
     *
     * @param periodInSecond  执行周期
     * @param durationInSeconds 持续时间
     */
    public void startRepeatReport(long periodInSecond, long durationInSeconds){
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry: requestInfos.entrySet()){
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    RequestStat stat = Aggregator.aggregate(requestInfosPerApi, durationInSeconds);
                    stats.put(apiName, stat);
                }
                System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
                Gson gson = new Gson();
                System.out.println(gson.toJson(stats));
            }
        }, 0,periodInSecond, TimeUnit.SECONDS);
    }
}

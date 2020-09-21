package com.zyj.cms.core.service.geek.codedesign.metrics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: zhouyajun
 * @date: 2020-02-16
 */
public class Aggregator {
    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMilles){
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo: requestInfos){
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime){
                maxRespTime = respTime;
            }
            if (minRespTime > respTime){
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }
        if (count != 0){
            avgRespTime = sumRespTime / count;
        }
        long tps = count / durationInMilles * 1000;
        requestInfos.sort((o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            }
            return 0;
        });

        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0){
            p99RespTime = requestInfos.get(idx99).getResponseTime();
            p999RespTime = requestInfos.get(idx999).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        return requestStat;
    }
}

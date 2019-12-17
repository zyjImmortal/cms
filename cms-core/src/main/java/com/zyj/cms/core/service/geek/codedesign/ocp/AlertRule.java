package com.zyj.cms.core.service.geek.codedesign.ocp;

/**
 * @author : zhouyajun
 * @date : 2019-12-17
 */
public enum AlertRule {

    /**
     * 一般api
     */
    NORMAL_API("normal", 200, 300),
    PAY_API("pay", 300, 500);

    private String api;
    private long tps;
    private long errorCount;

    AlertRule(String api, long tps, int errorCount) {
        this.api = api;
        this.tps = tps;
        this.errorCount = errorCount;
    }

    public AlertRule getMatchRule(String apiType) {
        AlertRule alertRule = null;
        if (apiType.equals(NORMAL_API.api)){
            alertRule = AlertRule.NORMAL_API;
        }
        return alertRule;
    }

    public String getApi(){
        return this.api;
    }

    public long getMaxErrorCount() {
        return this.errorCount;
    }

    public long getMaxTps(){
        return this.tps;
    }
}



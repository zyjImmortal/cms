package com.zyj.cms.core.service.geek.codedesign.ocp.handlers;

import com.zyj.cms.core.service.geek.codedesign.ocp.AlertRule;
import com.zyj.cms.core.service.geek.codedesign.ocp.ApiStatInfo;
import com.zyj.cms.core.service.geek.codedesign.ocp.notice.Notification;
import com.zyj.cms.core.service.geek.codedesign.ocp.notice.NotificationEmergencyLevel;

/**
 * Author: zhouyajun
 * Date: 2019-12-17
 */
public class TpsAlertHandler extends BaseAlertHandler {


    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchRule(apiStatInfo.getApi()).getMaxTps()){
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}

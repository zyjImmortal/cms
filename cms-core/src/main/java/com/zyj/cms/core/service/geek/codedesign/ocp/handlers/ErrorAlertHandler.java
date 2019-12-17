package com.zyj.cms.core.service.geek.codedesign.ocp.handlers;

import com.zyj.cms.core.service.geek.codedesign.ocp.AlertRule;
import com.zyj.cms.core.service.geek.codedesign.ocp.ApiStatInfo;
import com.zyj.cms.core.service.geek.codedesign.ocp.notice.Notification;
import com.zyj.cms.core.service.geek.codedesign.ocp.notice.NotificationEmergencyLevel;

/**
 * @author: zhouyajun
 * @date: 2019-12-17
 */
public class ErrorAlertHandler extends BaseAlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchRule(apiStatInfo.getApi()).getMaxErrorCount()){
            notification.notify(NotificationEmergencyLevel.SERVER, "...");
        }
    }
}

package com.zyj.cms.core.service.geek.codedesign.ocp.handlers;

import com.zyj.cms.core.service.geek.codedesign.ocp.AlertRule;
import com.zyj.cms.core.service.geek.codedesign.ocp.ApiStatInfo;
import com.zyj.cms.core.service.geek.codedesign.ocp.notice.Notification;

/**
 * @author : zhouyajun
 * @date : 2019-12-17
 */
public abstract class BaseAlertHandler {
    protected AlertRule rule;
    protected Notification notification;
    public BaseAlertHandler(AlertRule rule, Notification notification){
        this.rule = rule;
        this.notification = notification;
    }

    /**
     * 检查接口状态是否要进行handler处理
     *
     * @param apiStatInfo 接口状态信息
     */
    public abstract void check(ApiStatInfo apiStatInfo);

}

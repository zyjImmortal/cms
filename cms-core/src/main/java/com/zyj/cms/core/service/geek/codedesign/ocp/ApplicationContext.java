package com.zyj.cms.core.service.geek.codedesign.ocp;

import com.zyj.cms.core.service.geek.codedesign.ocp.notice.Notification;

/**
 * @author: zhouyajun
 * @date: 2019-12-17
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans(){
        alertRule = AlertRule.NORMAL_API;

    }
}

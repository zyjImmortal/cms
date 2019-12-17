package com.zyj.cms.core.service.geek.codedesign.ocp.notice;

/**
 * Author: zhouyajun
 * Date: 2019-12-17
 */
public abstract class Notification {

    public abstract void notify(NotificationEmergencyLevel level, String message);
}

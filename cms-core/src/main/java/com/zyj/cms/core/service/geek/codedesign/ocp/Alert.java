package com.zyj.cms.core.service.geek.codedesign.ocp;

import com.zyj.cms.core.service.geek.codedesign.ocp.handlers.BaseAlertHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhouyajun
 * Date: 2019-12-17
 */
public class Alert {

    private List<BaseAlertHandler> alertHandlers = new ArrayList<BaseAlertHandler>();
    public void addHandlers(BaseAlertHandler alertHandler){
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo){
        for(BaseAlertHandler alertHandler: this.alertHandlers){
            alertHandler.check(apiStatInfo);
        }
    }
}

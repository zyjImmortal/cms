package com.zyj.cms.core.service.geek.codedesign.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhouyajun
 * @date: 2019-12-20
 */
public class IpAddressUtil {

    /**
     * 判断ip是否合法
     *
     * @param ipAddress ip地址
     * @return 合法返回true，不合法返回false
     */
    public boolean isValidIpAddress(String ipAddress) {
        if (StringUtils.isBlank(ipAddress)) {
            return false;
        }

        String[] ipUnits = StringUtils.split(ipAddress, ".");
        if (ipUnits.length != 4) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int ipUnitIntValue;
            try {
                ipUnitIntValue = Integer.parseInt(ipUnits[i]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (ipUnitIntValue < 0 || ipUnitIntValue > 255) {
                return false;
            }
            if (i == 0 && ipUnitIntValue == 0) {
                return false;
            }
        }
        return true;
    }
}

package com.zyj.cms.core.service.geek.codedesign.orientobject;

/**
 * Author: zhouyajun
 * Date: 2019-12-17
 */
public interface ApiAuthInterface {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}

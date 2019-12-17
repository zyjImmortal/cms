package com.zyj.cms.core.service.geek.codedesign.orientobject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
//import org.apache.coyote.
/**
 * Author: zhouyajun
 * Date: 2019-12-16
 */
public class AuthToken {

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createdTime) {
        this.createTime = createdTime;
        this.token = token;
    }

    public AuthToken(String token, long createdTime, long expiredTimeInterval) {
        this.createTime = createdTime;
        this.token = token;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public String getToken(){
        return this.token;
    }

    public static AuthToken create(String url, String applId, String scret, long createTime) {
        String newToken = null;
        Map<String, String> body = new HashMap<String, String>();
        body.put("url", url);
        body.put("created_time", String.valueOf(createTime));
        body.put("appl_id", applId);
        body.put("scret", scret);

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] bytes = body.toString().getBytes();
            md.update(bytes);
            byte[] resultBytes = md.digest();
            StringBuilder builder = new StringBuilder();
            for (byte b : resultBytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    builder.append(bt);
                }
                builder.append(Integer.toHexString(bt));
            }
            newToken = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new AuthToken(newToken, createTime);

    }

    public boolean match(String token) {
        return false;
    }

    public boolean isExpired(AuthToken token) {
        return false;
    }

    public static void main(String[] args) {
        AuthToken authToken = AuthToken.create("http://www.baidu.com", "asdfafaf",
                "124566", System.currentTimeMillis());
        System.out.println(authToken.getToken());
    }
}

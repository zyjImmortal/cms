package com.zyj.cms.core.service.geek.codedesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


/**
 * @author: zhouyajun
 * @date: 2020-02-04
 */
public class RandomIdGenerator implements IdGenarator {

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() {
        String hostname = getLastfieldofHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomChars = generateRandomAlphameric(8);
        return String.format("%s-%d-%s", hostname, currentTimeMillis, randomChars);
    }

    private String getLastfieldofHostName() {
        String subofHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostAddress();
            String[] tokens = hostName.split("\\.");
            if (hostName.length() > 0) {
                subofHostName = tokens[tokens.length - 1];
            }
            return subofHostName;
        } catch (UnknownHostException e) {
            logger.error("failed to get host name.", e);
        }
        return subofHostName;
    }

    private String generateRandomAlphameric(int length) {
        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            // 122 是ascii表中小写字母的最后一个字符z
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit= randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase= randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase= randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit|| isUppercase || isLowercase) { randomChars[count] = (char) (randomAscii); ++count; }
        }
        return new String(randomChars);
    }
}

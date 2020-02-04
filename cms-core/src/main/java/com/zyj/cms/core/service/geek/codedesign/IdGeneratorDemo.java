package com.zyj.cms.core.service.geek.codedesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author : zhouyajun
 * @date : 2020-01-27
 */
public class IdGeneratorDemo {
    private static final Logger logger = LoggerFactory.getLogger(IdGeneratorDemo.class);

    public static String generate() {
        String id = "";
        try {
            String hostName = InetAddress.getLocalHost().getHostAddress();
            String[] tokens = hostName.split("\\.");
            if (hostName.length() > 0) {
                hostName = tokens[tokens.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8) {
                // 122 是ascii表中小写字母的最后一个字符z
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
//                count++;
            }
            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));
        } catch (UnknownHostException e) {
            logger.info("Failed to get the host name.", e);
        }

        return id;
    }

    public static void main(String[] args) throws UnknownHostException {
//        String hostname = InetAddress.getLocalHost().getHostName();
//        String[] tokens = hostname.split("\\.");
//        System.out.println(tokens.length);
//        for (int i = 0; i < tokens.length; i++) {
//            System.out.println(tokens[i]);
//        }
//        System.out.println(hostname);
//        System.out.println((char) ('0' + 4));
        System.out.println(IdGeneratorDemo.generate());
        System.out.println(IdGeneratorDemo.generate());
        System.out.println(IdGeneratorDemo.generate());
        System.out.println(IdGeneratorDemo.generate());
    }
}

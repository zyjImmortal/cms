package com.zyj.cms.core.service.book.dev.socket;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Author: zhouyajun
 * Date: 2019-07-09
 */
public class UrlDemo {

    public static void getHtmlByScanner() throws Exception{
        URL url = new URL("http", "www.mldnjava.cn", 80,"/curriculum.htm");

        try {
            InputStream stream = url.openStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        UrlDemo.getHtmlByScanner();
    }
}

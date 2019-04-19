package com.zyj.cms.core.service.book.logic.container;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author zhouyajun
 * @date 2019/4/17
 */
public class HashMapDemo {

    /**
     * 线程不安全
     */
    private Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 线程安全
     */
    private Map<String, Object> tanble = new Hashtable<String, Object>();
}

package com.zyj.cms.core.service.book.logic.interfaces;

/**
 * @author zhouyajun
 * @date 2019/4/15
 */
public class Base {
    private String member;
    public static String s = "static_string";
    public String m = "base";

    /**
     * 这个类只有一个带参数的构造方法，没有默认构造方法。这个时候，
     * 它的任何子类都必须在构造方法中通过super(...)调用Base的带参数构造方法
     * @param member
     */
    public Base(String member){
        this.member = member;
    }

    public static void staticTest(){
        System.out.println("base static:" + s);
    }
}

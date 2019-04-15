package com.zyj.cms.core.service.book.logic.extend;

/**
 * @author zhouyajun
 * @date 2019/4/15
 */
public class Base {
    public static int s;
    private int a;

    static {
        System.out.println("基类静态代码块, s: "+s);
        s = 1;
    }

    {
        System.out.println("基类实例代码块, a: "+a);
        a = 1;
    }

    public Base(){
        System.out.println("基类构造方法, a: "+a);
        a = 2;
    }

    /**
     * protected修饰的方法可以被子类和同一个包中的其他类访问
     */
    protected void step(){
        System.out.println("base s: " + s +", a: "+a);
    }

    public void action(){
        System.out.println("start");
        step();
        System.out.println("end");
    }
}

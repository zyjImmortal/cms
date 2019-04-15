package com.zyj.cms.core.service.book.logic.interfaces;

/**
 *
 * 子类可以重写父类的非private方法，当执行的时候。会动态绑定，执行子类的方法
 *
 * @author zhouyajun
 * @date 2019/4/15
 */
public class Child extends Base{
    public static String s = "chile_string";
    public String m = "child";
    public Child(String member) {
        super(member);
    }

    public static void staticTest(){
        System.out.println("child static:" + s);
    }

    public String getName(){
        return this.m ;
    }

    public static void main(String[] args) {
        // 实例变量、静态变量、静态方法、private方法，都是静态绑定的,在编译时就确定了类型的
        //
        Child c = new Child("2");
        Base b = c;
        System.out.println(b.s);
        System.out.println(b.m);
        b.staticTest();

        System.out.println(c.s);
        System.out.println(c.m);
        c.staticTest();

        Base b2 = new Child("3");
        System.out.println(b2.s);
        System.out.println(b2.m);
        b2.staticTest();
        System.out.println(((Child) b2).getName());
    }
}

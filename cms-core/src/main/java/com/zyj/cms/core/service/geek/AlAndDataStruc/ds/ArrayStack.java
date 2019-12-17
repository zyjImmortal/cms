package com.zyj.cms.core.service.geek.AlAndDataStruc.ds;

/**
 * Author: zhouyajun
 * Date: 2019-12-09
 */
public class ArrayStack {
    private String[] items;
    private int count;
    private int n;

    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item){
        if (count == n){
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    public String pop(){
        if (count == 0){
            return null;
        }
        String tmp = items[0];
        --count;
        return tmp;
    }

}
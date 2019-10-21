package com.zyj.cms.core.service.book.spring.bean;


import org.springframework.stereotype.Component;
//@Component("sdd") 指定id
@Component // 标记一个类为bean，不指定id的话会默认给一个，就是类名的小写
public class SgtPeppers implements CompactDisc {

    private String title = "这是一个title";
    private String artist = "这是一个乐队";
    @Override
    public void play() {
        System.out.println("播放:" + title + "由" + artist);
    }
}

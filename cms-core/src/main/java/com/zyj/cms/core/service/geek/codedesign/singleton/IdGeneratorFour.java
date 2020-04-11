package com.zyj.cms.core.service.geek.codedesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorFour {
    private AtomicLong id = new AtomicLong(0);
    private IdGeneratorFour(){
        // 初始化代码
    }

    private static class SingletonHolder{
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance(){
        return SingletonHolder.instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

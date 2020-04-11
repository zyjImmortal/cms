package com.zyj.cms.core.service.geek.codedesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorThree {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;
    private IdGeneratorThree(){
        // 初始化代码
    }

    public static IdGenerator getInstance(){
        if (instance == null){
            synchronized (IdGenerator.class){
                if (instance == null){
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

package com.zyj.cms.core.service.geek.codedesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorTwo {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;
    private IdGeneratorTwo(){}

    public static synchronized IdGenerator getInstance(){
        if (instance == null){
            instance = new IdGenerator();
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

package com.zyj.cms.core.service.geek.codedesign.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGeneratorEnum {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);
    public long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGeneratorEnum.INSTANCE.getId());
    }
}

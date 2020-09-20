package com.zyj.cms.core.service.geek.codedesign.di;

public class NoSuchBeanDefinitionException extends Exception {
    private String message;
    public NoSuchBeanDefinitionException(String s) {
        this.message = s;
    }
}

package com.zyj.cms.core.service.geek.codedesign.di;

public class BeanCreationFailureException extends Exception {

    public BeanCreationFailureException(String s, ReflectiveOperationException e) {
    }

    public BeanCreationFailureException(String s, Exception e) {
    }
}

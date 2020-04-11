package com.zyj.cms.core.service.geek.codedesign.exceptions;

import java.io.IOException;
import java.io.Serializable;

public class Exceptions {
    public static void main(String[] args) {
//        Throwable
//                Error
//                Exception
//        LinkageError,NoClassDefFoundError,UnsatisfiedLinkError

//        ExceptionInInitializerError

//        VirtualMachineError
//        OutOfMemoryError
//          StackOverflowError
//        IOException

//            RuntimeException
//        NullPointerException
//        ClassCastException
//        SecurityException
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

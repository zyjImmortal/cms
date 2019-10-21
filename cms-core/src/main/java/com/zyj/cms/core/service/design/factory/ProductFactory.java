package com.zyj.cms.core.service.design.factory;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class ProductFactory {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
    }
}

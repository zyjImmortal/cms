package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

/**
 * @author : zhouyajun
 * @date : 2020-01-16
 */
public class ACNode {
    public char data;
    public ACNode[] children = new ACNode[26];
    public boolean isEndingChar = false;
    public int length = -1;
    public ACNode fail;

    public ACNode(char data) {
        this.data = data;
    }
}

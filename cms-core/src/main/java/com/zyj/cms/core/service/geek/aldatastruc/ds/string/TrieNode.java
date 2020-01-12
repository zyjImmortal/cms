package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    // 标记字符是不是最后一个字符
    public boolean isEndingChar = false;
    public TrieNode(char data){
        this.data = data;
    }
}

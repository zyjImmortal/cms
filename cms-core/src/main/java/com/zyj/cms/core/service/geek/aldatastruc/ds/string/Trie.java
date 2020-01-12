package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

public class Trie {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            // 确定字符该存的位置
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode node = new TrieNode(c);
                p.children[index] = node;
            }
            // 如果已经存在节点了，就指向下一个节点
            p = p.children[index];
        }
        // 循环完成p指向了尾部字符
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern){
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            // 如果一条路径都到达叶子节点了，还没有匹配到，就说明不存在这个pattern
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        // 如果是尾部字符，就说明匹配到了，如果不是说明pattern只是一个前缀
        return p.isEndingChar;
    }

}

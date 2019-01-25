package com.learn.datastructureandalgorithm.lesson35_trietree;

/**
 * 字典树
 * Created by Administrator on 2019/1/9.
 */
public class TrieTree {
    //根节点
    private TrieNode root = new TrieNode('/');

    //往字典树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(text[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    //在字典树中查找指定字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public char data;
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("hello".toCharArray());
        trieTree.insert("hi".toCharArray());
        trieTree.insert("her".toCharArray());

        System.out.println(trieTree.find("he".toCharArray()));
        System.out.println(trieTree.find("her".toCharArray()));
    }
}

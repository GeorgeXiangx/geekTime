package com.learn.test;

import java.util.Collections;

/**
 * Created by XJH on 2019/6/12.
 *
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        String test = "/";
        String dir = test.substring(0, test.lastIndexOf("/"));
        System.out.println(dir);
        System.out.println(dir.lastIndexOf("/"));
        System.out.println(dir.substring(dir.lastIndexOf("/") + 1));

        String key = "a/b/";
        //从父目录删除数据
        String dir2 = key.substring(0, key.lastIndexOf("/"));
        System.out.println(dir2);
        //获取父目录
        String name = dir2.substring(dir2.lastIndexOf("/") + 1);
        System.out.println(name);

        System.out.println(String.format("%da%d", 100 % 64, 100));
        Collections.emptyList();
    }
}

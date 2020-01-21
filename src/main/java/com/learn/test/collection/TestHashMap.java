package com.learn.test.collection;

import java.util.HashMap;

/**
 * Created by XJH on 2019/12/31.
 *
 * @Description:
 */
public class TestHashMap {
    public static void main(String[] args) {
        new Object();
//        Integer

        HashMap<Object, Object> map = new HashMap<>();
//        System.out.println(map.put(1, "1"));
//        System.out.println(map.put(2, "2"));
//        System.out.println(map.put(1, "11"));
//
//        System.out.println(map.put(null, null));
//        System.out.println(map.put(null, "131"));

        System.out.println(map.put(-1, "-----1"));

        System.out.println(map.put(0, "000"));

        System.out.println(map.get(1));
        System.out.println(map.get(null));
    }
}

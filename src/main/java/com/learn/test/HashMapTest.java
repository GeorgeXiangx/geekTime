package com.learn.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by XJH on 2019/8/16.
 *
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "1");
        map.put(2, "2");

        //  最常见也是大多数情况下用的最多的，一般在键值对都需要使用
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 方法二：在for循环中遍历key或者values，一般适用于只需要map中的key或者value时使用，在性能上比使用entrySet较好
        for (Integer i : map.keySet()) {
            System.out.println(i.toString());
        }
        for (String s : map.values()) {
            System.out.println(s);
        }

        // 方法三：通过Iterator遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey() + " : " + iterator.next().getValue());
        }

        // 方法四：通过键找值遍历，这种方式的效率比较低，因为本身从键取值是耗时的操作
        for (Integer i : map.keySet()) {
            System.out.println(i + " --> " + map.get(i));
        }
    }
}

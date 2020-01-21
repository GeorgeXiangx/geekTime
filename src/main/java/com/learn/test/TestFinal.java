package com.learn.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by XJH on 2019/6/24.
 *
 * @Description:
 */
public class TestFinal {

    private static final long TEST_LONG = 10;

    public int test_int = 1;

    public static void main(String[] args) {
        TestFinal testFinal = new TestFinal();
//        TestFinal.TEST_LONG = 100;
        testFinal.test_int = 10;
        System.out.println(TestFinal.TEST_LONG);

        Map<String, Integer> map = new HashMap();
        map.put("leo", 1);
        map.put("tom", 22);

        System.out.println(map.get("leo"));
        System.out.println(map.get("Leo"));

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }
    }
}

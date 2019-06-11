package com.learn.test;

import java.util.*;

/**
 * Created by XJH on 2019/4/9.
 *
 * @Description:
 */
public class TestStringUtils {
    public static void main(String[] args) {
        double[] d = new double[5];
        d[0] = 1;
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        Map map = new HashMap();
        map.put("1", "(1,2)");
        map.put("2", "(1,2)");
        map.put("1", "(2,3)");


        Map subMap = new HashMap();
        subMap.put("2014", 1);
        subMap.put("2015", 2);

        map.put("1", subMap);

        List list1 = new ArrayList();
        list1.add("1");
        list1.add("2");

        List list2 = new ArrayList();
        list2.add("1");
        list2.add("3");

        System.out.println("-------------------");
        Set<String> set = (Set)getDiffentNoDuplicate(list1, list2);
        for (String s : set) {
            System.out.println(s);
        }
    }

    /**
     * 获取两个集合的不同元素
     *
     * @param collmax
     * @param collmin
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Collection getDiffent(Collection collmax, Collection collmin) {
        //使用LinkeList防止差异过大时,元素拷贝
        Collection csReturn = new LinkedList();
        Collection max = collmax;
        Collection min = collmin;
        //先比较大小,这样会减少后续map的if判断次数
        if (collmax.size() < collmin.size()) {
            max = collmin;
            min = collmax;
        }
        //直接指定大小,防止再散列
        Map<Object, Integer> map = new HashMap<Object, Integer>(max.size());
        for (Object object : max) {
            map.put(object, 1);
        }
        for (Object object : min) {
            if (map.get(object) == null) {
                csReturn.add(object);
            } else {
                map.put(object, 2);
            }
        }
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                csReturn.add(entry.getKey());
            }
        }
        return csReturn;
    }

    /**
     * 获取两个集合的不同元素,去除重复
     *
     * @param collmax
     * @param collmin
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Collection getDiffentNoDuplicate(Collection collmax, Collection collmin) {
        return new HashSet(getDiffent(collmax, collmin));
    }
}



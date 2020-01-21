package com.learn.test.bit_operate;

import java.util.*;

/**
 * Created by XJH on 2019/12/23.
 *
 * @Description:
 */
public class Substract_31 {
    public static void main(String[] args) {
        int i = 1;
        int temp = (i << 5) - 1;
        System.out.println(temp);

        System.out.println(1 << 30);
        System.out.println(Integer.MAX_VALUE);

//        HashMap map = new HashMap(Integer.MAX_VALUE);
        HashMap<Integer, String> map = new HashMap();
        map.put(3, "2");

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();
        while (objectObjectTreeMap.entrySet().iterator().hasNext()){
            objectObjectTreeMap.entrySet().iterator().next();
        };

        HashSet<Object> objects = new HashSet<>();

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
    }
}

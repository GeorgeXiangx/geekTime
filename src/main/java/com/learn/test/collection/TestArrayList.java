package com.learn.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by XJH on 2019/12/12.
 *
 * @Description:
 */
public class TestArrayList {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("A");
        list1.add("V");

        List list2 = new ArrayList();
        list2.add("A");

//        list1.retainAll(list2);

        list1.addAll(list2);

        print(list1);

//        LinkedList
//        Collection
    }

    public static void print(Collection c) {
        Object[] objects = c.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}

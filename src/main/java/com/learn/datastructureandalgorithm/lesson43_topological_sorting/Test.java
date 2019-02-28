package com.learn.datastructureandalgorithm.lesson43_topological_sorting;

import java.util.LinkedList;

/**
 * Created by XJH on 2019/2/14.
 *
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> test[] = new LinkedList[10];
        test[0] = new LinkedList<Integer>();

        if (test[0].add(10)) {
            System.out.println(test[0].get(0));
        } else {
            System.out.println("Error");
        }

    }
}

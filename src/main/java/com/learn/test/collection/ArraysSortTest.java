package com.learn.test.collection;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by XJH on 2020/2/20.
 *
 * @Description:
 */
public class ArraysSortTest {
    public static void main(String[] args) {
        int[] a = {3, 1, 5};
        printArray(a);
        Arrays.sort(a);
        printArray(a);
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

package com.learn.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by XJH on 2019/4/4.
 *
 * @Description:
 */
public class TestSort {
    public static void main(String[] args) {
        int array2[][] = new int[][]{
                {12, 34, 68, 32, 9, 12, 545},
                {34, 72, 82, 57, 56, 0, 213},
                {12, 34, 68, 32, 21, 945, 23},
                {91, 10, 3, 2354, 73, 34, 18},
                {12, 83, 189, 26, 27, 98, 33},
                {47, 23, 889, 24, 899, 23, 657},
                {12, 34, 68, 343, 878, 235, 768},
                {12, 34, 98, 56, 78, 12, 546},
                {26, 78, 2365, 78, 34, 256, 873}};

        double array[][] = new double[][]{
                {12.01, 34, 68, 32, 9, 12, 545},
                {34.33, 72, 82, 57, 56, 0, 213},
                {12.67, 34, 68, 32, 21, 945, 23},
                {91, 10, 3, 2354, 73, 34, 18},
                {12, 83, 189, 26, 27, 98, 33},
                {47, 23, 889, 24, 899, 23, 657},
                {12, 34, 68, 343, 878, 235, 768},
                {12, 34, 98, 56, 78, 12, 546},
                {26, 78, 2365, 78, 34, 256, 873}};

        sortIntArray(array, new int[]{0, 1});    // 先根据第一列比较，若相同则再比较第二列

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void sortIntArray(double[][] arObjects, final int[] arOrders) {
        Arrays.sort(arObjects, new Comparator<Object>() {

            public int compare(Object oObjectA, Object oObjectB) {
                double[] arTempOne = (double[]) oObjectA;
                double[] arTempTwo = (double[]) oObjectB;

                for (int i = 0; i < arOrders.length; i++) {
                    int k = arOrders[i];
                    if (arTempOne[k] > arTempTwo[k]) {
                        return 1;
                    } else if (arTempOne[k] < arTempTwo[k]) {
                        return -1;
                    } else {
                        continue;
                    }
                }

                return 0;
            }
        });
    }

    public static void sortIntArray(int[][] arObjects, final int[] arOrders) {
        Arrays.sort(arObjects, new Comparator<Object>() {

            public int compare(Object oObjectA, Object oObjectB) {
                int[] arTempOne = (int[]) oObjectA;
                int[] arTempTwo = (int[]) oObjectB;

                for (int i = 0; i < arOrders.length; i++) {
                    int k = arOrders[i];
                    if (arTempOne[k] > arTempTwo[k]) {
                        return 1;
                    } else if (arTempOne[k] < arTempTwo[k]) {
                        return -1;
                    } else {
                        continue;
                    }
                }

                return 0;
            }
        });
    }
}

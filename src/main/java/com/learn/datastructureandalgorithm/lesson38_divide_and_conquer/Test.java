package com.learn.datastructureandalgorithm.lesson38_divide_and_conquer;

/**
 * Created by XJH on 2019/1/23.
 *
 * @Description:
 */
public class Test {
    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q - i + 1); // 统计 p-q 之间，比 a[j] 大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) { // 处理剩下的
            tmp[k++] = a[i++];
        }
        while (j <= r) { // 处理剩下的
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r - p; ++i) { // 从 tmp 拷贝回 a
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 6, 2, 3, 4};
        System.out.println("before = " + arrayPrinter(test));
        System.out.println("Inversion is : " + new Test().count(test, 6));
        System.out.println("after = " + arrayPrinter(test));
    }

    public static String arrayPrinter(int[] array) {
        String res = "";
        for (int i = 0; i < array.length; i++) {
            res += array[i] + " ";
        }
        return res;
    }
}

package com.learn.datastructureandalgorithm.lesson11_sort_part1;

/**
 * Created by XJH on 2020/4/10.
 *
 * @Description:冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(Integer[] a, int size) {

        if (size <= 1) {
            return;
        }

        // 循环整个数组，这里i的主要作用是控制第二次for循环交换数据只能遍历未排序区间(因为每次冒泡都会保证把当前区间最大的值放到当前区间的最后)
        for (int i = 0; i < size; ++i) {
            // 设置提前退出标志
            boolean flag = false;

            // 遍历当前区间并挨个两两比较元素，将当前区间最大的元素放置到最后(冒泡)
            for (int j = 0; j < size - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            // 如果没有交换，说明已排好序无须继续
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{4, 5, 6, 3, 2, 1};
        print(a);
        bubbleSort(a, a.length);
        print(a);
    }

    public static <T> void print(T[] a) {
        for (T element : a) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}

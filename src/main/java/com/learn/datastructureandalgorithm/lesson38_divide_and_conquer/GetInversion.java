package com.learn.datastructureandalgorithm.lesson38_divide_and_conquer;

/**
 * Created by XJH on 2019/1/23.
 *
 * @Description:
 */
public class GetInversion {
    private int totalNum = 0;

    /**
     * 统计逆序对个数
     *
     * @param a 需统计的数组
     * @param n 数组的长度
     * @return 逆序对个数
     */
    public int count(int[] a, int n) {
        totalNum = 0;
        mergerSortCounting(a, 0, n - 1);
        return totalNum;
    }

    /**
     * 归并排序的思想来递归(分治思想)
     *
     * @param a     数组
     * @param start 起始下标
     * @param end   结束下标
     */
    private void mergerSortCounting(int[] a, int start, int end) {
        //起始下标大于等于结束下标直接返回
        if (start >= end) return;
        //求出数组中间下标
        int middle = (start + end) / 2;
        //分解任务,递归求子任务
        mergerSortCounting(a, start, middle);
        mergerSortCounting(a, middle + 1, end);
        //合并求逆序对，从原子任务开始依次往上执行(归操作)  a,0,0,1 -> 分解为原子数组(2个数不能再继续拆分)
        merge(a, start, middle, end);
    }

    /**
     * 分解之后的合并算法，求出逆序对个数
     *
     * @param a      数组
     * @param start  起始下标
     * @param middle 中间下标
     * @param end    结束下标
     */
    private void merge(int[] a, int start, int middle, int end) {
        //初始化中间变量
        int s = start, m = middle + 1, t = 0;
        //初始化中间数组,主要用于将子任务中的数组进行排序
        int[] tmp = new int[end - start + 1];

        //0 <= 0 && 1 <= 1
        while (s <= middle && m <= end) {
            //a[0] <= a[1] (1 <= 5)
            if (a[s] <= a[m]) {
                //tmp[0] = a[0] -> 1
                tmp[t++] = a[s++];
            } else {
                //统计 start - middle 之间，比 a[m] 大的元素个数
                totalNum += (middle - s + 1);
                tmp[t++] = a[m++];
            }
        }

        //处理剩下的
        //1 <= 0
        while (s <= middle) {
            tmp[t++] = a[s++];
        }

        //处理剩下的
        //1 <= 1
        while (m <= end) {
            //tmp[1] = a[1] -> 5
            tmp[t++] = a[m++];
        }

        //将临时数组(已有序)中的数据拷贝回原数组
        //end - start = 1
        for (s = 0; s <= end - start; ++s) {
            //a[0 + 0] = tmp[0]
            //a[0 + 1] = tmp[1]
            a[start + s] = tmp[s];
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 6, 2, 3, 4};
        System.out.println("before = " + Test.arrayPrinter(test));
        System.out.println("Inversion is : " + new GetInversion().count(test, 6));
        System.out.println("after = " + Test.arrayPrinter(test));
    }
}

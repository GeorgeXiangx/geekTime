package com.learn.datastructureandalgorithm.lesson34_kmp;

/**
 * Created by Administrator on 2019/1/10.
 */
public class KMP {
    /**
     * KMP算法
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        //根据模式串计算出next数组[失效函数(failure function)]
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {

            //一直找到 a[i] 和 b[j]
            //模式串前缀的长度 > 1时，且模式串和主串相同位置上的字符不相同时。
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }

            //如果主串和模式串相同位置的字符相等，那么模式串的计数器+1
            if (a[i] == b[j]) {
                ++j;
            }

            if (j == m) {//找到匹配模式串了
                return i - m + 1;
            }
        }
        return -1;
    }


    private static int[] getNexts(char[] b, int m) {
        return new int[0];
    }
}

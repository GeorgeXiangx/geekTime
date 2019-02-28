package com.learn.datastructureandalgorithm.lesson42_dynamic_programming_3;

/**
 * Created by XJH on 2019/2/13.
 *
 * @Description: 回溯求莱文斯坦距离
 */
public class LevenshteinDistanceBT {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();

    private int n = 6;
    private int m = 6;

    private int minDist = Integer.MAX_VALUE; // 存储结果

    // 调用方式 lwstBT(0, 0, 0);
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) { // 两个字符匹配
            lwstBT(i + 1, j + 1, edist);
        } else { // 两个字符不匹配
            lwstBT(i + 1, j, edist + 1); // 删除 a[i] 或者 b[j] 前添加一个字符
            lwstBT(i, j + 1, edist + 1); // 删除 b[j] 或者 a[i] 前添加一个字符
            lwstBT(i + 1, j + 1, edist + 1); // 将 a[i] 和 b[j] 替换为相同字符
        }
    }

    public static void main(String[] args) {
        LevenshteinDistanceBT ld = new LevenshteinDistanceBT();
        ld.lwstBT(0, 0, 0);
        System.out.println(ld.minDist);
    }
}

package com.learn.datastructureandalgorithm.lesson42_dynamic_programming_3;

/**
 * Created by XJH on 2019/2/13.
 *
 * @Description: 动态规划求莱文斯坦距离
 * <p>
 * 状态转移方程:
 * 如果：a[i]!=b[j]，那么：min_edist(i, j) 就等于：
 * min(min_edist(i-1,j)+1, min_edist(i,j-1)+1, min_edist(i-1,j-1)+1)
 * <p>
 * 如果：a[i]==b[j]，那么：min_edist(i, j) 就等于：
 * min(min_edist(i-1,j)+1, min_edist(i,j-1)+1，min_edist(i-1,j-1))
 * 其中，min 表示求三数中的最小值。
 */
public class LevenshteinDistanceDP {

    /**
     * @param a 字符串a
     * @param n 字符串a的长度n
     * @param b 字符串b
     * @param m 字符串b的长度m
     * @return 莱文斯坦距离
     */
    public int lwstDP(char[] a, int n, char[] b, int m) {
        //1.首先初始化好填表的二维数组
        int[][] minDist = new int[n][m];
        //2.初始化二维数组
        //初始化第0行,[0][0]到[0][m - 1]的编辑距离
        //初始化第 0 行:a[0..0] 与 b[0..j] 的编辑距离
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {//字母相同
                minDist[0][j] = j;
            } else if (j != 0) {
                //使用状态转移方程
                minDist[0][j] = minDist[0][j - 1] + 1;
            } else {
                minDist[0][j] = 1;
            }
        }

        // 初始化第 0 列:a[0..i] 与 b[0..0] 的编辑距离
        for (int i = 0; i < n; i++) {
            if (b[0] == a[i]) {
                minDist[i][0] = i;
            } else if (i != 0) {
                minDist[i][0] = minDist[i - 1][0] + 1;
            } else {
                minDist[i][0] = 1;
            }
        }

        //3.按行填表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {//字母相同时
                    minDist[i][j] = mini(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                } else {//字母不同时
                    minDist[i][j] = mini(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
                }
            }
        }

        return minDist[n - 1][m - 1];
    }

    //求最小值
    private int mini(int x, int y, int z) {
        int minValue = Integer.MAX_VALUE;
        if (x < minValue) minValue = x;
        if (y < minValue) minValue = y;
        if (z < minValue) minValue = z;
        return minValue;
    }

    public static void main(String[] args) {
        LevenshteinDistanceDP ld = new LevenshteinDistanceDP();
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();

        System.out.println(ld.lwstDP(a, a.length, b, b.length));
    }
}

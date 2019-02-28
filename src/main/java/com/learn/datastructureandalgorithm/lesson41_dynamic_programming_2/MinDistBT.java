package com.learn.datastructureandalgorithm.lesson41_dynamic_programming_2;

/**
 * Created by XJH on 2019/1/29.
 *
 * @Description: 回溯算法，递归穷举
 */
public class MinDistBT {

    private int minDist = Integer.MAX_VALUE;

    public void getMinDisBT(int i, int j, int dist, int[][] w, int n) {
        int k = n - 1;

        if (i == n && j == n) {
            System.out.println(">>>>>>>>>>>> i = " + i + " j = " + j + " dist = " + dist);
            if (dist < this.minDist) minDist = dist;
            return;
        }

        //往下走
        if (i < n) {
            System.out.println(".1. i = " + i + " j = " + j + " minDist = " + minDist);
            getMinDisBT(i + 1, j, dist + w[i][j], w, n);
        }

        //往右走
        if (j < n) {
            System.out.println(".2. i = " + i + " j = " + j + " minDist = " + minDist);
            getMinDisBT(i, j + 1, dist + w[i][j], w, n);
        }

        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        MinDistBT mdbt = new MinDistBT();
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
//        int[][] matrix = {{1, 3, 5, 9, 0}, {2, 1, 3, 4, 0}, {5, 2, 6, 7, 0}, {6, 8, 4, 3, 0}, {0, 0, 0, 0, 0}};
        mdbt.getMinDisBT(0, 0, 0, matrix, 3);
        System.out.println(mdbt.minDist);
    }
}

package com.learn.datastructureandalgorithm.lesson_41_dynamic_programming_2;

/**
 * Created by XJH on 2019/1/29.
 *
 * @Description: 假设我们有一个n乘以n的矩阵w[n][n]。矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。
 * 我们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。我们把每条路径经过的数字加起来看作路径的长度。
 * 那从左上角移动到右下角的最短路径长度是多少呢？
 */
public class MinDistDP {

    /**
     * 获取矩阵从左上方到右下方的最短路径
     *
     * @param matrix 矩阵数组
     * @param n      矩阵边长
     * @return 最短距离
     */
    public static int getMatrixMinDistDP(int[][] matrix, int n) {
        //1.首先初始化矩阵
        int[][] states = new int[n][n];
        int sum = 0;
        //初始化第一行
        for (int i = 0; i < n; i++) {
            sum += matrix[0][i];
            states[0][i] = sum;
        }

        sum = 0;
        //初始化第一列
        for (int j = 0; j < n; j++) {
            sum += matrix[j][0];
            states[j][0] = sum;
        }

        //2.状态递推
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //states[1][1]开始
                states[i][j] = Math.min(states[i - 1][j], states[i][j - 1]) + matrix[i][j];
            }
        }

        return states[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        int res = MinDistDP.getMatrixMinDistDP(matrix, 4);
        System.out.println(res);
    }
}

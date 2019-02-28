package com.learn.datastructureandalgorithm.lesson40_dynamic_programming_1;

/**
 * Created by XJH on 2019/1/28.
 *
 * @Description:对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 */
public class PackageProblemPlus {

    /**
     * @param weight 物品重量数组
     * @param value  物品价值数组
     * @param n      有多少个物品
     * @param w      背包可承载重量
     * @return
     */
    public static int dynamicPro(int weight[], int value[], int n, int w) {
        //初始化存放动态规划结果的数组容器
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                //每个位置存放的价格初值为-1
                states[i][j] = -1;
            }
        }

        //初始化第一个物品选择状态，并在其基础上进行动态的状态转移推算
        states[0][0] = 0;
        states[0][weight[0]] = value[0];

        //动第二个物品开始推算  (i, cw, cv)
        for (int i = 1; i < n; i++) {
            //1.不选择第i个物品
            for (int j = 0; j < w; j++) {
                //基于现有的状态进行动态推算(金额>=0)
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }

            //2.选择第i个物品
            for (int j = 0; j < w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    //叠加同一列(同一重量状态)的value值
                    int resValue = value[i] + states[i - 1][j];
                    if (resValue > states[i][j + weight[i]]) {
                        //由于有相同的(i, cw)留下value最大的
                        states[i][j + weight[i]] = resValue;
                    }
                }
            }
        }

        int maxValue = -1;
        //取出满足条件的最大值
        for (int i = 0; i < w; i++) {
            if (states[n - 1][i] > maxValue) maxValue = states[n - 1][i];
        }
        return maxValue;
    }
}

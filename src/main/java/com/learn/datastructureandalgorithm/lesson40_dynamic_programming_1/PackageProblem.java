package com.learn.datastructureandalgorithm.lesson40_dynamic_programming_1;

/**
 * Created by XJH on 2019/1/28.
 *
 * @Description:使用动态规划解决背包问题，在背包可承受范围内，如何让能装的物品重量最大
 */
public class PackageProblem {

    /**
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值 false
        //初始化第一行数据
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;

        //i行,j列
        for (int i = 1; i < n; ++i) { // 动态规划状态转移

            // 不把第 i 个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }

            // 把第 i 个物品放入背包
            for (int j = 0; j <= w - weight[i]; ++j) {
                //动态的在上一次的基础上进行状态的推导
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }

        for (int i = w; i >= 0; --i) { // 输出结果
            //只输出最后一行，从后到前输出最优解
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3};
        int res = new PackageProblem().knapsack(weight, 5, 9);
        System.out.println(res);
    }
}

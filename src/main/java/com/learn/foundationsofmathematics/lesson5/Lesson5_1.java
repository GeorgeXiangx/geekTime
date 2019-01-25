package com.learn.foundationsofmathematics.lesson5;

import java.util.ArrayList;

/**
 * 递归
 * Created by Administrator on 2018/12/27.
 */
public class Lesson5_1 {
    public static long[] rewards = {1, 2, 5, 10};

    /**
     * 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合
     *
     * @param totalRewards 总奖金金额
     * @param result       用于保存结果的result数组
     */
    public static void get(long totalRewards, ArrayList<Long> result) {
        // 当 totalReward = 0 时，证明它是满足条件的解，结束嵌套调用，输出解
        if (totalRewards == 0) {
            System.out.println(result);
            return;
        } else if (totalRewards < 0) {
            //当 totalReward < 0 时，证明它不是满足条件的解，直接返回
            return;
        } else {
            //继续嵌套递归调用
            //找出可能出现的金额
            for (int i = 0; i < rewards.length; i++) {
                ArrayList<Long> res = (ArrayList<Long>) result.clone();
            }
        }
    }
}

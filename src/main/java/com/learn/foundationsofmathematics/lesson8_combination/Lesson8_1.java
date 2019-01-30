package com.learn.foundationsofmathematics.lesson8_combination;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 组合
 * Created by Administrator on 2019/1/7.
 */
public class Lesson8_1 {

    /**
     * 在一系列队中(teams)挑选出m个队进行组合操作
     * 使用函数的递归（嵌套）调用，找出所有可能的队伍组合
     *
     * @param teams  可选队伍
     * @param result 结果集
     * @param m      指定的挑选次数
     */
    public static void combine(ArrayList<String> teams, ArrayList<String> result, int m) {
        //挑选完了m个元素，输出结果
        if (result.size() == m) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < teams.size(); i++) {
            //从剩下的队伍中挑选一支队伍加入结果
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(teams.get(i));

            //将挑选出的队伍从列表中移除
            ArrayList<String> rest_teams = new ArrayList<String>(teams.subList(i + 1, teams.size()));
            //递归调用,对于剩余的队伍继续生产组合
            combine(rest_teams, newResult, m);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<String>(Arrays.asList("t1", "t2", "t3", "t4"));
        combine(teams, new ArrayList<String>(), 1);
    }
}

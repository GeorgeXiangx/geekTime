package com.learn.foundationsofmathematics.lesson7;

import java.util.*;

/**
 * 排列
 * Created by Administrator on 2019/1/3.
 */
public class Lesson7_1 {
    //设置齐王的马跑完所需时间
    public static Map<String, Double> q_hourse_time = new HashMap<String, Double>() {
        {
            put("q1", 1.0);
            put("q2", 2.0);
            put("q3", 3.0);
        }
    };

    //设置田忌的马跑完所需时间
    public static Map<String, Double> t_hourse_time = new HashMap<String, Double>() {
        {
            put("t1", 1.5);
            put("t2", 2.5);
            put("t3", 3.5);
        }
    };

    public static List<String> q_horses = new ArrayList<String>(Arrays.asList("q1", "q2", "q3"));

    /**
     * 递归调用，找出所有的马匹出战顺序
     *
     * @param horses 可选的战马(目前还有多少匹战马没有出战)列表
     * @param result 已选的战马(用于保存当前已经出战的战马及顺序)
     */
    public static void permutate(ArrayList<String> horses, ArrayList<String> result, int times) {
        //已经全部选完
        if (horses.size() == 0) {
            System.out.println(result);
            compare(result, q_horses);
            System.out.println();
            return;
        }

        for (int i = 0; i < horses.size(); i++) {
            //从剩下的马中选一匹加入
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            new_result.add(horses.get(i));

            //将选择出战的马从未出战列表中移除
            ArrayList<String> new_horses = (ArrayList<String>) horses.clone();
            new_horses.remove(i);

            System.out.println("times = " + times);
            System.out.println("i = " + i);
            System.out.println("horses = " + new_horses);
            System.out.println("result = " + new_result);
            System.out.println();

            permutate(new_horses, new_result, ++times);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> horses = new ArrayList<String>(Arrays.asList("t1", "t2", "t3"));
        Lesson7_1.permutate(horses, new ArrayList<String>(), 0);
    }

    //compare 的函数来比较田忌和齐王的马匹，看哪方获胜
    private static void compare(ArrayList<String> t, List<String> q) {
        int t_won_count = 0;
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t_hourse_time.get(t.get(i)) + " " + q_hourse_time.get(q.get(i)));
            if (t_hourse_time.get(t.get(i)) < q_hourse_time.get(q.get(i)))
                t_won_count++;
        }

        if (t_won_count > t.size() / 2)
            System.out.println("田忌获胜");
        else
            System.out.println("齐王获胜");

        System.out.println();
    }
}


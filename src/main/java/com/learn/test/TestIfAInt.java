package com.learn.test;

/**
 * Created by XJH on 2019/5/6.
 *
 * @Description:
 */
public class TestIfAInt {
    public static void main(String[] args) {
        double a = 100.0;
        double b = 11.11;
        System.out.println(isIntegerForDouble(a));
        System.out.println(isIntegerForDouble(b));
    }

    /**
     * 判断double是否是整数
     *
     * @param obj
     * @return
     */
    public static boolean isIntegerForDouble(double obj) {
        double eps = 1e-10;  // 精度范围
        return obj - Math.floor(obj) < eps;
    }
}

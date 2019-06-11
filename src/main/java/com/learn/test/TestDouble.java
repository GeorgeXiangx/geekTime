package com.learn.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by XJH on 2019/3/25.
 *
 * @Description:
 */
public class TestDouble {
    public static void main(String[] args) {
        double a = 64.0;
        int b = 1282;
        double c = 0.025;
        double test = a + b * c;
        double test2 = 2.33333333333333333333;

        float bandWidth = 50;
        double frequency = 101.7;
        float r = 25 / 2000;
        BigDecimal fre = new BigDecimal("101.7");
        BigDecimal band = new BigDecimal("50");
        System.out.println(fre.add(band.divide(new BigDecimal(2000))));

        double res = frequency + bandWidth / 2000;
        System.out.println(r);
        System.out.println(res);

        DecimalFormat df = new DecimalFormat("#.0000");
        System.out.println(test);
        System.out.println(String.format("%.6f", test2));
//        System.out.println(new BigDecimal(test).toString());
//        System.out.println(df.format(test));
        System.out.println(Double.parseDouble(getStrFromFrequency(test2)));
    }

    public static String getStrFromFrequency(double frequency) {
//        DecimalFormat df = new DecimalFormat("#.000000");
//        String frequencyStr = df.format(frequency);
        //四舍五入到小数六位Hz
        String frequencyStr = String.format("%.6f", frequency);
        String[] splits = frequencyStr.split("\\.");
        //将整数部分填充5位，不够左边补0
        String integerPart = String.format("%05d", Integer.parseInt(splits[0]));
        return integerPart + "." + splits[1];
    }
}

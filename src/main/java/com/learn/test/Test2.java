package com.learn.test;

/**
 * Created by XJH on 2019/3/28.
 *
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        double s = 20;
        double t = 101.7;
        double step = 12.5;
        System.out.println((t - s) / (step / 1000));
        System.out.println((t * 1000 - s * 1000) / step);

        double test = 101.725;
        byte[] bytes = double2Bytes(test);
        byte[] bytes2 = String.valueOf(test).getBytes();
        System.out.println(bytes2Double(bytes));
        System.out.println(bytes.length);
        System.out.println(bytes2.length);

        System.out.println("@@" + getStrFromFrequency("88.025"));
    }

    public static double bytes2Double(byte[] arr) {
        long value = 0;
        for (int i = 0; i < 8; i++) {
            value |= ((long) (arr[i] & 0xff)) << (8 * i);
        }
        return Double.longBitsToDouble(value);
    }

    public static byte[] double2Bytes(double d) {
        long value = Double.doubleToRawLongBits(d);
        byte[] byteRet = new byte[8];
        for (int i = 0; i < 8; i++) {
            byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
        }
        return byteRet;
    }

    //frequency转化为00000.111111 12位的字符串
    public static String getStrFromFrequency(String frequency) {
        //四舍五入到小数六位Hz
        String frequencyStr = String.format("%1$0" + (6 - frequency.length()) + "d", 0);
        System.out.println(frequencyStr);
        String[] splits = frequencyStr.split("\\.");
        //将整数部分填充5位，不够左边补0
        String integerPart = String.format("%05d", Integer.parseInt(splits[0]));
        return integerPart + "." + splits[1];
    }
}

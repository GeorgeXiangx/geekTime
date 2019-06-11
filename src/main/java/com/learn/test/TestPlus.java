package com.learn.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XJH on 2019/4/1.
 *
 * @Description:
 */
public class TestPlus {
    public static void main(String[] args) {
        int c = 0;
        int b = 0;
        System.out.println(++c);
        System.out.println(b++);

        System.out.println(c);
        System.out.println(b);

        Set<byte[]> set = new HashSet();
        String s = "123";
        byte[] a = s.getBytes();
        set.add(a);

        String s1 = "1234";
        byte[] a1 = s1.getBytes();
        set.add(a1);

        String s2 = "123";
        byte[] a2 = s2.getBytes();
        set.add(a2);

        for (byte[] res : set) {
            System.out.println(new String(res));
        }


        Set<Double> set2 = new HashSet();

        set2.add(101.1);
        set2.add(101.1);
        set2.add(31.1);

        for (Double d : set2) {
            System.out.println(d);
        }


        System.out.println("===========================");
        String[] test = new String[3];
        test[0] = "0";
        test[1] = "1";
        test[2] = "2";
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        String[] res = new String[5];
        System.arraycopy(test, 0, res, 0, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


        byte ss = 100;
        char cc = (char) ss;
        System.out.println(cc);

        double dd = 101.7;
        char cc2 = (char) dd;
        System.out.println(cc2);

        String aaa = "aaa";
        byte[] ab = aaa.getBytes();
        System.out.println(String.valueOf(ab));
        System.out.println(new String(ab));
    }
}

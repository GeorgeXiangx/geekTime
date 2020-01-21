package com.learn.test.collection;

/**
 * Created by XJH on 2020/1/2.
 *
 * @Description:
 */
public class TestEqualsAndHashcode {
    public static void main(String[] args) {
        Person p1 = new Person(1);
        Person p2 = new Person(1);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(Integer.MAX_VALUE);
        System.out.println((-1) ^ (-1 >>> 16));
        System.out.println(-1 >>> 16);
        System.out.println(15 & -65536);

        System.out.println("----------------------");
        System.out.println(Integer.toBinaryString(-1 >>> 16));
        System.out.println(Integer.toBinaryString(-1 >> 16));

        System.out.println(Integer.toBinaryString(-5 >>> 1));
        System.out.println(-5 >>> 1 );

        System.out.println("----------------------");
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println("----------------------");
        System.out.println(-1 & 0x7FFFFFFF);
    }

    static class Person {
        int age;

        Person(int age) {
            this.age = age;
        }
    }

}

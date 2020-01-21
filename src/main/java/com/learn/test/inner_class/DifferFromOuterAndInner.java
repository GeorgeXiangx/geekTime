package com.learn.test.inner_class;

/**
 * Created by XJH on 2019/12/11.
 *
 * @Description:
 */
public class DifferFromOuterAndInner {
    static String outterString = "outter";
    int c = 10;

    class Inner {
        String a = "a";
        // inner class cannot have static declarations
        // static String b = "b";

        void print() {
            System.out.println(a + outterString + c);
        }

        // inner class cannot have static declarations
//        static void staticPrint(){
//
//        }
    }

    static class StaticInner {
        String a = "a";
        static String b = "b";

        void print() {
            System.out.println(a);
        }

        static void staticPrint() {
//            System.out.println(b + outterString + c);
            System.out.println(b + outterString);
        }
    }

    public static void main(String[] args) {
        StaticInner si = new DifferFromOuterAndInner.StaticInner();

        DifferFromOuterAndInner dfoi = new DifferFromOuterAndInner();
        DifferFromOuterAndInner.Inner inner = dfoi.new Inner();
    }
}

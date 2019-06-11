package com.learn.concurrentprogramming.multiprotest;

import java.util.Arrays;

/**
 * Created by XJH on 2019/5/7.
 *
 * @Description:
 */
public class SimulatedCAS {
    volatile int count;

    public void addOne() {
        int newValue;
        do {
            newValue = count + 1;
        } while (count != cas(count, newValue));
    }

    private synchronized int cas(int expect, int newValue) {
        int curValue = count;
        System.out.println("---------" + expect);
        if (curValue == expect) {
            count = newValue;
        }
        return curValue;
    }

    public static void main(String[] args) {
        SimulatedCAS simulatedCAS = new SimulatedCAS();
        simulatedCAS.addOne();
        System.out.println(simulatedCAS.count);

//        SimulatedCAS simulatedCAS2 = new SimulatedCAS();
//        int res = simulatedCAS2.cas(0, 1);
//        System.out.println(res);
//
//        int count = 0;
//        int nv = 1;
//        int cv = count;
//        count = nv;
//        System.out.println(cv + " @ " + count);
    }
}

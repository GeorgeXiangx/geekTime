package com.learn.test.bit_operate;

/**
 * Created by XJH on 2020/1/13.
 *
 * @Description:
 */
public class TestLeftMoveForInt {
    public static final int RESIZE_STAMP_BITS = 16;

    public static void main(String[] args) {
        int rs = resizeStamp(16);
        System.out.println(rs);
        System.out.println(Integer.toBinaryString(rs));
    }

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
    }
}

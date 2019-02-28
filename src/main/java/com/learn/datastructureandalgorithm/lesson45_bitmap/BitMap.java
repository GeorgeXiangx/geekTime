package com.learn.datastructureandalgorithm.lesson45_bitmap;

/**
 * Created by XJH on 2019/2/20.
 *
 * @Description: 与运算 &  规则 ：都为1时才为1
 * 或运算 |  规则：有一个为1，则为1
 * 异或运算  ^ 规则：不同为1
 * 取反运算 ~ 规则：按位取反
 */
public class BitMap {
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        // Java 中 char 类型占 16bit，也即是 2 个字节
        this.bytes = new char[nbits / 16 + 1];
    }

    public void set(int k) {
        if (k > nbits) return;
        //在char数组中的下标
        int byteIndex = k / 16;
        //一个数组元素有16位，具体的位下标
        int bitIndex = k % 16;
        //知道了指定位所在的位置，此时就要判断该位是否为1了。可以通过位运算来判断。
        //因为指定位在下标为n的数组元素上的偏移量为offset
        //所以，先将1左移offset位之后，再与下标为n的数组元素进行按位"与(&)"操作
        bytes[byteIndex] |= (1 << bitIndex);//1左移butIndex位
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10);
        bitMap.set(1);
        bitMap.set(1);
        System.out.println("--" + String.valueOf(bitMap.bytes[0]) + "@");
        System.out.println(bitMap.get(1) + " " + bitMap.get(2));
        int t = 3;
        System.out.println(1 << t);
//        ConcurrentHashMap
//        CopyOnWriteArrayList
    }

    /**
     * EWAHCompressedBitmap
     * LW:Literal Word 直接存储数据
     * RLW:Running Length Word 存储跨度信息(游程编码)
     */
}

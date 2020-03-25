package com.learn.test.generic.interfaces;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:泛型实现类,实现类和接口的泛型标识必须一致
 * 可以在以上的基础进行泛型的扩充Impl2<T,E>
 */
public class Impl2<K, V> implements GenericInterface<K> {

    private K t;
    private V v;

    public Impl2(K t, V v) {
        this.t = t;
        this.v = v;
    }

    @Override
    public K get() {
        return t;
    }

    public V getV() {
        return v;
    }

    public static void main(String[] args) {
        Impl2<String, Integer> stringIntegerImpl2 = new Impl2<String, Integer>("age", 100);
        System.out.println(stringIntegerImpl2.get() + " " + stringIntegerImpl2.getV());
    }
}

package com.learn.test.generic.wildcard;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:
 */
public class Box<E> {

    private E first;

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }
}

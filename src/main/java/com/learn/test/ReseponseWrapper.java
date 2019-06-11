package com.learn.test;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJH on 2019/5/9.
 *
 * @Description:
 */
public class ReseponseWrapper<T> {
    private String mark;
    private T bean;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public static void main(String[] args) {
//        Object[] o = new Object[2];
////        String[] s = o;
//        String[] ss = minMax("Tom", "Jack");
//        Arrays.stream(ss).forEach(s -> System.out.println(s));

        ReseponseWrapper<List<String>> rw = new ReseponseWrapper<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        rw.setBean(list);
        rw.setMark("查询成功");
        System.out.println(rw.getMark());
        rw.getBean().forEach(b -> System.out.println(b));

        double step = 25.0;
        System.out.println(String.valueOf(step));

        System.out.println("------------------");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        List<String> list2 = new ArrayList<>();
        List<String> list3 = null;
        for (String s : list3) {
            System.out.println(s);
        }
    }

    public static <T> T[] minMax(T... a) {
        Object mm = new Object[2];
        return (T[]) mm;
    }
}

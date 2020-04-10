package com.learn.test.generic.wildcard.lowerlimit;

import com.learn.test.generic.wildcard.upperlimit.Animal;
import com.learn.test.generic.wildcard.upperlimit.Cat;
import com.learn.test.generic.wildcard.upperlimit.MiniCat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:
 */
public class TestLowerLimit {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<MiniCat> miniCats = new ArrayList<>();

        showAnimals(animals);
        showAnimals(cats);
        // 不能传子类类型
//        showAnimals(miniCats);
    }

    /**
     * 泛型下限通配符，传递的集合类型，只能是Cat或者Cat的父类型
     * @param list
     */
    public static void showAnimals(List<? super Cat> list) {
        // 下限能填充元素但不保证类型
//        list.add(new Cat());
//        list.add(new MiniCat());

//        list.add(new Animal());

        for (int i = 0; i < list.size(); i++) {
            // 使用Object类型来接收
            Object object = list.get(i);
            System.out.println(object);
        }
    }
}

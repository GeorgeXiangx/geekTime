package com.learn.test.generic.wildcard.upperlimit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:
 */
public class TestUpperLimit {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<MiniCat> miniCats = new ArrayList<>();

//        cats.addAll(animals);
        cats.addAll(miniCats);

        showAnimals(cats);
    }

    /**
     * 泛型上限通配符，传递的集合类型，只能是Cat或者Cat的子类型
     * @param list
     */
    public static void showAnimals(List<? extends Cat> list) {
        // 上限通配符不能往其中添加元素
        // 原因：由于List集合变量list并不知道自己能够存储的数据类型，list不能判断你要加入的对象是否满足条件
        // 比如此时list是一个plant的集合，那么你就不能把Life的对象加入进去,更不能将Animal对象加进去。
        // 所以list不能添加Life及其子类Plant和Animal对象。

//        list.add(new Animal());
//        list.add(new Cat());
//        list.add(new MiniCat());

        for (int i = 0; i < list.size(); i++) {
            Cat animal = list.get(i);
            System.out.println(animal);
        }
    }
}

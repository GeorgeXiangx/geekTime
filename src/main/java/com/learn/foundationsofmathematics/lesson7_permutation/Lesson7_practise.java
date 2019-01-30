package com.learn.foundationsofmathematics.lesson7_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/1/3.
 */
public class Lesson7_practise {
    public static List<Character> letter = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
    public static List<Character> pwd = new ArrayList<Character>(Arrays.asList('c', 'd', 'a', 'e'));

    public static void permutate(int length, ArrayList<Character> result) {
        if (length == 0) {
            System.out.println(result);
            if (result.equals(pwd)) {
                System.out.println("password is = " + result);
            }
            return;
        }

        for (int i = 0; i < letter.size(); i++) {
            //选出字母并将组合的长度减一
            ArrayList<Character> new_list = (ArrayList<Character>) result.clone();
            new_list.add(letter.get(i));
            permutate(length - 1, new_list);
        }
    }

    public static void main(String[] args) {
        permutate(4, new ArrayList<Character>());
    }
}

package com.learn.foundationsofmathematics.lesson7_permutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/1/3.
 */
public class HelloPermutation {
    public static ArrayList<String> letter = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
    public static ArrayList<String> pwd = new ArrayList<String>(Arrays.asList("b", "a", "c", "d"));

    public static void main(String[] args) {
        System.out.println(letter);
        System.out.println("Hello Permutation!");
        permutate(pwd.size(), new ArrayList<String>());
    }

    public static void permutate(int len, ArrayList<String> result) {
        if (len == 0) {
            if (result.equals(pwd))
                System.out.println("password: " + result);
            return;
        }
        for (int i = 0; i < letter.size(); i++) {
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            new_result.add(letter.get(i));
            permutate(len - 1, new_result);
        }
    }
}

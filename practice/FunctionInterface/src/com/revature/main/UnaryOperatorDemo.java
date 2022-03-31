package com.revature.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<String> func= (x1)->x1.toUpperCase();
        UnaryOperator<Integer> func1= (x1)->x1*10;
        System.out.println(func.apply("soma"));
        System.out.println(func1.apply(20));
        List<String> list =new ArrayList<>(Arrays.asList("soma","nikhil","neithan"));
        list.replaceAll(ele->ele+"mampakulathu");
        System.out.println(list);
    }
}

package com.revature.main;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
    BinaryOperator<Integer> func = (x1, x2)->x1+x2;
        System.out.println(func.apply(10,20));

    }
}

package com.revature.main;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<String,Integer> func =x->x.length();
        Function<Integer,Integer> func2 =x->x*2;

        String s ="i love neithan";
        func.andThen(func2).apply(s);
        System.out.println(func.andThen(func2).apply(s)) ;
        System.out.println(func.apply(s));
    }
}

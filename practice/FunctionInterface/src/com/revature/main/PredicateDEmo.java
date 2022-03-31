package com.revature.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDEmo {
    public static void main(String[] args) {
        Predicate<Integer> func1 =x1->x1>5;
        System.out.println(func1.test(8));
        List<Integer> list1 =new ArrayList<>(Arrays.asList(1,2,4,8,9));
        List<Integer>list2=list1.stream().filter(func1).collect(Collectors.toList());
        System.out.println(list2);
        String abc = “”;
        abc.concat(“abc”);
        abc.concat(“def”);
        System.out.println(abc);

    }
}

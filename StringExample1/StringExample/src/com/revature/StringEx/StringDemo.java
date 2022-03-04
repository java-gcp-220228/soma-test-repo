package com.revature.StringEx;

public class StringDemo {
    public static void main(String args[]) {
        String s1 = "heloo";
        String s2 = "world";
        s1 =s1.concat(s2);
        System.out.println(s1);
        StringBuilder str = new StringBuilder(s1);
        System.out.println(str.reverse());
    }
}

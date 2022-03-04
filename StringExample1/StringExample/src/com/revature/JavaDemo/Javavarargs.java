package com.revature.JavaDemo;

public class Javavarargs {
    int val;
    public int Sum(int ...arr){

        for (int e:arr) {
             val =val+e;
        }
        return val;
    }
    public static void main(String[] args) {
        Javavarargs obj1 =new Javavarargs();
        int sum = obj1.Sum(2,3,5,6,6);
        System.out.println(sum);
    }
}

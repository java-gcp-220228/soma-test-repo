package com.revature.main;

import java.util.*;

public class LinkedlistDemo {
    public static void main(String[] args) {
        LinkedList<String> list =new LinkedList<>(Arrays.asList("soma","nikhil","neithan"));


        list.add(1,"amma");
        list.add(2,"achan");
        list.addFirst("Family");

        Iterator<String> it =list.iterator();
           while(it.hasNext()){
               System.out.println(it.next());
           }

    }
}

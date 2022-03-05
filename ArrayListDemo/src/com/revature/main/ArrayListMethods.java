package com.revature.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListMethods {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("soma");
        list1.add("nikhil");
        list1.add("neithan");

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("soumya","ishan","ishan", "sharath", "akshara", "ishan", "neithan"));
        //add all
        // list1.addAll(list2);
        //iterator

        //
           /*System.out.println(list1.get(1));

        System.out.println(list2.retainAll(list1));
        System.out.println(list1.indexOf("soma"));
        System.out.println(list1.lastIndexOf("nikhil"));
        list1.remove(1);
        list1.remove("soma");
*/
        ArrayList<Integer> list3 =new ArrayList<Integer> (Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ArrayList<Integer> list4 = new ArrayList<>(list3.subList(2,8));
        ArrayList<Integer> clonelist3 = (ArrayList<Integer>)list3.clone();
        System.out.println(clonelist3);
        System.out.println(list4);
        Object[] arr =list4.toArray();
        System.out.println(Arrays.toString(arr));
      //  System.out.println(list3.removeIf(num->num%2!=0));
        Iterator<Integer> it = list3.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(list2.retainAll(Collections.singleton("ishan")));
        Iterator<String> it1 = list2.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

    }    }


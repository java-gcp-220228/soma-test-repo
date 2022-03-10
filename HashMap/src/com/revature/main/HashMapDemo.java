package com.revature.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) throws ParseException {
     /*   HashMap<Integer,String> map1 =new HashMap<>();
        map1.put(1,"soma");
        map1.put(2,"nikhil");
        map1.put(3,"neithan");
        map1.put(4,"family");
       for (Map.Entry m : map1.entrySet()){
           System.out.println(m.getKey());
           System.out.println(m.getValue());
       }
        for (String val: map1.values())

        System.out.println(val);

        for (int i:map1.keySet()) {
            System.out.println(i);*/
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        System.out.println(new Date());
        String dateWithoutTime = sdf.format(new Date());
        System.out.println(dateWithoutTime);


        }
       }



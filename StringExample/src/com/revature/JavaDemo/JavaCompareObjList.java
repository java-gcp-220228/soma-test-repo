package com.revature.JavaDemo;

import java.util.LinkedHashSet;

public class JavaCompareObjList {
    public int age;
    public String name;

    public  JavaCompareObjList(int age,String name){
        this.age = age;
        this.name =name;
    }
    @Override
    public  String toString(){
        return  this.name +
                ','+ this.age;
    }
    @Override
    public boolean equals(Object obj)
    {   JavaCompareObjList other = (JavaCompareObjList) obj;
        return this.name.equals(other.name)&& this.age==other.age
                ;
    }
    @Override
    public int hashCode()
    {

        return 0;
    }


    public static void main(String[] args) {
        LinkedHashSet<Object> linkhashset =new LinkedHashSet<>();
        JavaCompareObjList obj1 =new JavaCompareObjList(22,"soma");
        JavaCompareObjList obj2 =new JavaCompareObjList(22,"soma");
        JavaCompareObjList obj3 =new JavaCompareObjList(24,"nikhil");
        JavaCompareObjList obj4 =new JavaCompareObjList(2,"neithan");
        linkhashset.add(obj1);
        linkhashset.add(obj2);
        linkhashset.add(obj3);
        linkhashset.add(obj4);
        System.out.println(linkhashset);
        System.out.println(obj1.toString());
        System.out.println(obj1==obj2);
        System.out.println(obj1.equals(obj2));
    }
}



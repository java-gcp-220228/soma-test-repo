package com.revature.JavaDemo;

public class JavaCompareObj {
    public String age;
    public String name;

    public  JavaCompareObj(String age,String name){
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
    {   JavaCompareObj other = (JavaCompareObj) obj;
        return this.name.equals(other.name)&& this.age.equals(other.age)
                ;
    }


    public static void main(String[] args) {
        JavaCompareObj obj1 =new JavaCompareObj("22","soma");
        JavaCompareObj obj2 =new JavaCompareObj("22","soma");
        System.out.println(obj1.toString());
        System.out.println(obj1==obj2);
        System.out.println(obj1.equals(obj2));
    }
}

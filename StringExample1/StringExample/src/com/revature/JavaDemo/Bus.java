package com.revature.JavaDemo;

import com.revature.parent.Vehicle;

public class Bus extends Vehicle {
     private String  color;
     private String name;

     public  Bus( String color,String name){
         this.color =color;
         this.name =name;

     }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String setColor(String color) {
        this.color = color;
        return color;
    }
}

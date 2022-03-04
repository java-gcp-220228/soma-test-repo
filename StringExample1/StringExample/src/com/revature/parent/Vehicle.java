package com.revature.parent;

import com.revature.JavaDemo.Bus;
import com.revature.JavaDemo.Car;

public class Vehicle {
    public  String engine;
    public void engineType()
    {
        System.out.println("***generic engine type");
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Bus("pink","santa-fe");

        v1.engineType();
       String name =((Bus)v2).getName();
       String color =((Bus)v1).setColor("black");
        System.out.println(color);
    }
}

package com.revature.JavaDemo;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name :");
        String name = sc.nextLine();
        System.out.println("Enter your age :");
        int age =Integer.parseInt( sc.nextLine());
        System.out.println("Your name :"+name+"and your age"+age + "has been noted");
    }
}

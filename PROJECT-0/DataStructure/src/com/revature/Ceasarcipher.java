package com.revature;

public class Ceasarcipher {
    public String check(String S) {
        String result="";
        StringBuilder sb = new StringBuilder();
        char [] arr =S.toCharArray();

        for(int i=0;i<S.length();i++){
            char pos=S.toLowerCase().charAt(i);
            if(arr[i]>='a' && arr[i]<='z')
            {
                sb.append('0');
                System.out.println(sb.append(pos-'a'+1));
            }else
            {
                System.out.println(sb.append(arr[i]));
            }


        }
        return result;


        //WRITE YOUR LOGIC HERE:


        //For optimizing code, You are free to make changes to "return type", "variables" and "Libraries".

        /*for (int i = 1; i < N; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if ((i % 5 == 0)) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return N;*/
    }
        public static void main (String[]args){
            Ceasarcipher cs = new Ceasarcipher();
            System.out.println(cs.check("ABC"));
        }
    }

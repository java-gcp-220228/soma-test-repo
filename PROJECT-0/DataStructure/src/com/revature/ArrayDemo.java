package com.revature;

public class ArrayDemo {

    public int length;
   String [] data = new String[]{"SOMA","NEIHAN","NIKHIL","SOU"};


    public ArrayDemo() {
        this.length = length;
        this.data = data;
    }
    public int add (String item){
        this.data[length] =item;
        length++;
        return length;
    }

    public int getLength() {
        return this.length;
    }
    public String get(int index){

        return  this.data[index];

    }
    public String[] removefromarr(String [] arr,int index){
        String [] newarray = new String[arr.length-1];
        for(int i=0;i<=arr.length-1;i++){
            if(i==index){
                newarray[i] =  arr[i+1];

                continue;
            }
           // newarray[i]=arr[i+];
        }
        return newarray;
    }

    public static void main(String[] args){
        ArrayDemo arr=new ArrayDemo();
      //  int arrlen =arr.add("soma");
        System.out.println(arr.data[0]);
        String data = arr.get(0);
        System.out.println(data);
        arr.removefromarr(arr.data,1);
    }
}

package com.revature.main;

public class ArrayListDemo<E> {
    int size;
    private E[] value ;
    public ArrayListDemo() {
        this.value = (E[]) new Object[2];
    }



    public void add(E element) {
        //E[] oldArray;
        if (this.size == this.value.length) {
            E[] oldArray=this.value;
            this.value = (E[]) new Object[this.value.length * 2];
            for (int i = 0; i < oldArray.length;i++ )
            {
                this.value[i] =oldArray[i];
             }
        }
        this.value[size]=element;
        size++;
    }
    public E get(int index)
    {
        return this.value[index];
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size ==0;
    }
    public static void main(String[] args) {
        Person p1 = new Person("john","doe",24);
        Person p2 = new Person("Nikhil","sas",34);
        Person p3 = new Person("soma","jan",24);

    ArrayListDemo<Person> arrayListDemo =new ArrayListDemo<Person>();
        arrayListDemo.add(p1);
        arrayListDemo.add(p2);
        arrayListDemo.add(p3);
    for(int i=0;i< arrayListDemo.size;i++)
    {
        System.out.println(arrayListDemo.get(i));
    }
    }
}

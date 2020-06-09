package com.demo.test11;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class Test01 {
public static void main (String[] args){
    String a = new String("myString");
    String b = "myString";
    String e = new String("myString");
    String c = "my" + "String";
    String d = c;
    System.out.print(a == b);
    System.out.print(a == c);
    System.out.print(b == e);
    System.out.print(a == e);

    System.out.print(b == c);
    System.out.print(b == d);
    //System.out.println(i + ~j);
}


}

class A{
A(){
    System.out.println("A 的构造");
}
public void clonee(){

}
}
class B extends A{
B(){
    int array[] = new int[100];
    System.out.println("B 的构造");
    super.clonee();
}


}
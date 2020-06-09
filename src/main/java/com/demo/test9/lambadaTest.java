package com.demo.test9;

import java.io.FilenameFilter;
import java.util.*;

public class lambadaTest {


    //调用接口的方法
//    public static String hello(String name,Man man){
//        return man.eat(name);
//    }

    public static void main (String[] args){

//        String name = "abc";
//        String age = "abc";
//        Man<String> man = new Man<String>() {
//            @Override
//            public String eat(String name, String age) {
//                return null;
//            }
//        };
//
//        Man<String> test = (name, age) -> String.eat(name, age);
//===========================
//        Comparator<Integer> cpt = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        };
//
//        TreeSet<Integer> set = new TreeSet<>(cpt);
//
//        int x = 5; int y = 6;
        Comparator<Integer> cpt2 = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> set2 = new TreeSet<>(cpt2);

    }

}
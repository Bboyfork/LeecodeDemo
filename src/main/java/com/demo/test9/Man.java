package com.demo.test9;

public interface Man<T> {
    String eat(T name,T age);
    default void big(){
        System.out.println("这里是默认方法big~~");
    }
}

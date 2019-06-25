package com.demo.base.java8;

/**
 * Created by Krystal on 2019/4/3.
 */
public class LambdaTest {
    final static String salution = "hello!";
    public static void main(String args[]){
        final int i = 9;
        GreetService greetService = message -> System.out.println(salution + message + i);
        greetService.sayMessage("Runoob");
    }
}

package com.demo.base.java8;

/**
 * Created by Krystal on 2019/4/1.
 * java8允许我们给接口添加一个非抽象的方法实现，只需要使用default关键字即可。
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}

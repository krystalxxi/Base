package com.demo.base.java8.impl;

import com.demo.base.java8.Formula;

/**
 * Created by Krystal on 2019/4/1.
 */
public class FormulaImpl implements Formula {
    @Override
    public double calculate(int a){
       return Double.valueOf(a);
    }
    public static void main(String[] args){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a*100);
            }
        };
    }
}

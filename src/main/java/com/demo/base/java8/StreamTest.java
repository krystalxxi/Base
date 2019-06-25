package com.demo.base.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Krystal on 2019/4/3.
 */
public class StreamTest {
    public static void main(String[] args){
        List<String> stringList = Arrays.asList("abc","a","dbde","");
        List<String> filterd = stringList.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());

    }
}

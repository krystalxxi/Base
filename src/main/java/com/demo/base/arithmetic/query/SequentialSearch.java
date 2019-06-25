package com.demo.base.arithmetic.query;

/**
 * Created by Krystal on 2019/5/22.
 * 顺序查找
 * 时间复杂度：O(n)
 */
public class SequentialSearch {
    public static  int search(int[] arr,int key){
        int index  = arr.length - 1;
        // 返回-1表示未找到
        while (index >= 0 && arr[index] != key ){
           index--;
        }
        return index;
    }

    public static void main(String[] args){
        int[] arr = {39, 1, 56, 9, 19, 45, 3, 12, 99};
        int key = 40;
        int index = search(arr,key);
        System.out.println(index);
    }
}

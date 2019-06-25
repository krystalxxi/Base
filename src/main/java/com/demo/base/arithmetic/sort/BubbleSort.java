package com.demo.base.arithmetic.sort;

/**
 * Created by Krystal on 2019/5/22.
 * 冒泡排序
 * 时间复杂度O(n²)
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int length  = arr.length;
        for (int i = 0; i < length-1; i++){
            for(int j = 0; j < length - i -1; j++ ){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }

    public static void main(String[] args){
        int[] arr = {12,23,34,16,56,30,78};
        bubbleSort(arr);
        for (int i : arr){
            System.out.println(i+",");
        }
    }
}

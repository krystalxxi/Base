package com.demo.base.arithmetic.sort;

/**
 * Created by Krystal on 2019/5/22.
 * 选择排序
 * 时间复杂度：O(n²)
 */
public class SelectionSort {

    public static void selectSort(int[] arr){
        int index;
        for(int i = 0;i < arr.length-1;i++){
            index = i;
            for(int j = i + 1; j < arr.length-1;j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            if (index != i){
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {39, 1, 56, 9, 19, 45, 3, 12, 99};
        selectSort(arr);
        for(int i : arr){
            System.out.println(i+",");
        }
    }

}

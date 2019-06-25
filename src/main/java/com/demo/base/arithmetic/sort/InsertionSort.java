package com.demo.base.arithmetic.sort;

/**
 * Created by Krystal on 2019/5/22.
 * 插入排序
 * 时间复杂度：O(n²)
 */
public class InsertionSort {

    public static void sort(int[] arr){
        int length = arr.length;
        int j;
        int i;
        // 从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < length ; i++){
            // 待插入的数据
            int insertNode = arr[i];
            j = i - 1;
            while (j >= 0 && insertNode < arr[j]){
                // 如果待插入的数据小于arr[j],将arr[j]往后移一位
                arr[j+1] = arr[j];
                j--;
            }
            // 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
            arr[j+1] = insertNode;
        }
    }

    public static void main(String[] args){
        int[] arr = {39, 1, 56, 9, 19, 45, 3, 12, 99};
        sort(arr);
        for(int i : arr){
            System.out.println(i+",");
        }

    }
}

package com.demo.base.arithmetic.sort;

/**
 * Created by Krystal on 2019/5/22.
 * 快速排序
 * 时间复杂度O(nlogn)
 */
public class QuickSort {

    public static void quickSort(int[] arr, int low ,int high){
        if (low > high){
            return;
        }
        int i,j;
        i = low;
        j = high;
        // 基准值
        int temp = arr[low];
        while (i < j){
            // 比较左边,满足条件左边值小于基准值，往后移一位
            while (temp > arr[i] && i < j){
                i++;
            }

            //比较右边，满足条件右边值大于基准值，往前移一位
            while (temp < arr[j] && i < j){
                j--;
            }

            // 交换i，j位置的值
            if (i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // 左边排序 ,此处用i或者j都可以
        quickSort(arr,low,i-1);
        // 右边排序
        quickSort(arr,i+1,high);

    }

    public static void main(String[] args){
        int[] arr = {39,1,56,9,19,45,3,12,99};
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr,low,high);
        for (int i : arr){
            System.out.println(i+",");
        }
    }
}

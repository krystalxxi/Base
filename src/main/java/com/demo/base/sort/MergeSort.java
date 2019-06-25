package com.demo.base.sort;

import java.util.Arrays;

/**
 * Created by Krystal on 2019/5/13.
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, 0, arr.length - 1, tmp);
    }

    private static void sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr,left,mid,tmp);// 左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,tmp); // 右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,tmp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]){
                tmp[t++] = arr[i++];
            }else{
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= right) {
            tmp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

}

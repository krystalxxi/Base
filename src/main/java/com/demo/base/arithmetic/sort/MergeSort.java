package com.demo.base.arithmetic.sort;

/**
 * Created by Krystal on 2019/5/22.
 * 归并排序
 * 时间复杂度：O(nlogn)
 */
public class MergeSort {

    // 合并
    public static void merge(int[] arr, int first, int mid, int last, int[] temp) {
        int i = first;
        int m = mid;
        int j = mid + 1;
        int n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= n) {
            temp[k++] = arr[j++];
        }

        for (int t = 0; t < k; t++) {
            arr[first + t] = temp[t];
        }
    }

    // 拆分排序
    public static void sort(int[] arr, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            // 左边排序
            sort(arr, first, mid, temp);
            // 右边排序
            sort(arr, mid + 1, last, temp);
            // 合并
            merge(arr, first, mid, last, temp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {39, 1, 56, 9, 19, 45, 3, 12, 99};
        int[] temp = new int[arr.length];
        int first = 0;
        int last = arr.length - 1;
        sort(arr, first, last, temp);
        for (int i : arr) {
            System.out.println(i + ",");
        }
    }
}

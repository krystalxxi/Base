package com.demo.base.arithmetic.query;

/**
 * Created by Krystal on 2019/5/22.
 * 二分查找
 * 时间复杂度：O(log2n)
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (mid > 0) {
            if (key > arr[mid]) {
                return binarySearch(arr, mid+1, high, key);
            } else if (key < arr[mid]) {
                return binarySearch(arr, low, mid-1, key);
            } else {
                return mid;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 9, 10, 50};
        int key = 5;
        int index = binarySearch(arr, 0, arr.length - 1, key);
        System.out.println(index);
    }

}

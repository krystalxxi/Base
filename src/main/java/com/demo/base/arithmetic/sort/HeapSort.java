package com.demo.base.arithmetic.sort;

import java.util.Arrays;

/**
 * Created by Krystal on 2019/5/22.
 * 堆排序---最小堆
 * 时间复杂度：O(nlogn)
 */
public class HeapSort {

    /**
     * 排序
     * @param array
     */
    public static void sort(int[] array){
        // 按照完全二叉树的特点，从最后一个非叶子节点开始，对于整棵树进行最大堆的调整
        // 也就是说，是按照自下而上，每一层都是自右向左来进行调整的
        for(int i = array.length/2 -1 ;i >=0; i--){
            adjustHeap(array,i,array.length);
        }

        // 上述逻辑，建堆结束
        // 下面开始排序逻辑
        // 分别把每个元素放在根节点上，跟下面的子节点进行比较，找到其位置，类似于插入排序的算法
        for (int j = array.length -1; j > 0; j--){
            swap(array,0,j);
            adjustHeap(array,0,j);
        }
    }

    /**
     * 核心
     * @param array
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] array,int i,int length){
        // 先把当前元素取出来，因为当前元素可能要一直移动
        int temp = array[i];
        // 当前节点的子节点
        int left = 2*i+1;
        // 左节点：2*i+1 ， 2*k + 1 表示子节点的左子节点
        for (int k = left; k < length; k = 2*k + 1){
            // array[k] 左节点， array[k+1] 右节点
            // 比较左、右节点的值，找出左右节点中较大的那个值
            if (k + 1 < length && array[k] < array[k+1]){
                // 移动到下一个节点
                k++;
            }
            // 如果发现子节点更大，则进行值交换
            if (array[k] > temp){
                swap(array,i,k);
                i = k;
            }else {
                break;
            }
        }

    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] array = {2,1,4,3,6,5,8,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}

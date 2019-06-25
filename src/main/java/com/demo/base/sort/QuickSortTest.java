package com.demo.base.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krystal on 2019/5/13.
 * 快速排序
 */

public class QuickSortTest {
    public static void main(String[] args) {
        QuickSortTest quickSortTest = new QuickSortTest();
        List<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(8);
        list.add(1);
        list.add(2);
        list.add(67);
        list.add(5);
        list.add(38);
        list.add(118);
        list.add(37);
        list.add(43);
        quickSortTest.quickSort(list);
    }

    private void quickSort(List<Integer> list) {
        int end = list.size();
        int start = 0;
        int position = sort(list,start,end);
        // 排序左边
        int lend = position-1;
        sort(list,start,lend);
        // 排序右边
        int rstart = position+1;
        sort(list,rstart,end);
        System.out.println(list.toString());
    }

    private int sort(List<Integer> list,int start,int end){

        int x; // 用于交换的指针位置
        int y; // 用于交换的指针位置
        int position = start;
        int value = list.get(start);
        for (int i = start + 1; i < end; i++) {
            int a = list.get(i);  // 当前位置的值
            // 若参照值比当前值大，则当前值往左移动
            if (value > a) {
                // 设置当前值位置
                x = i;
                // 移动时跟左边的值一个个交换位置，不是直接交换位置
                for(int k = i - 1; k >= position; k--){
                    // 当前位置前一个值
                    int b = list.get(k);
                    // 若当前值比前一个值小，交换位置
                    if (a < b){
                        y = k;
                        change(list,x,y);
                        // 重新设置当前值位置
                        x = k;
                    }
                }
                position = i - 1;
            }
        }
        return position;
    }

    private void change(List<Integer> list, int start, int end) {
        int t = list.get(start);
        list.set(start, list.get(end));
        list.set(end, t);
    }

}

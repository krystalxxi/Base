package com.demo.base.arithmetic.query;

/**
 * Created by Krystal on 2019/5/22.
 * 二叉排序树查找
 */
public class BinarySortTreeSearch {
    class BinaryNode{
        int value;
        BinaryNode left;
        BinaryNode right;
        public BinaryNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public void add(int value){
            if (value > this.value){
                if (this.right != null){
                    this.right.add(value);
                }else {
                    this.right = new BinaryNode(value);
                }
            }else{
                if (this.left != null){
                    this.left.add(value);
                }else {
                    this.left = new BinaryNode(value);
                }
            }
        }
        // 中序查找
        public BinaryNode get(int value){
            if (this.value == value){
                return this;
            }
            if (this.value > value){
                return this.left.get(value);
            }else {
                return this.right.get(value);
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {4,1,6,9,5,12,3};
        BinarySortTreeSearch binarySortTreeSearch = new BinarySortTreeSearch();
        BinarySortTreeSearch.BinaryNode binaryNode = binarySortTreeSearch.new BinaryNode(0);

        for (int i:arr){
            binaryNode.add(i);
        }
        BinaryNode binaryNode1 = binaryNode.get(9);
        System.out.println(binaryNode1);

    }
}

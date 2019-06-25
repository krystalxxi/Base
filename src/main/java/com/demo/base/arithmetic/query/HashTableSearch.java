package com.demo.base.arithmetic.query;

/**
 * Created by Krystal on 2019/5/22.
 * 哈希表查找
 * 时间复杂度：O(1)
 */
public class HashTableSearch {

    /**
     * Hash表检索数据
     * @param hash
     * @param hashLength
     * @param key
     * @return
     */
    public static int searchHash(int[] hash,int hashLength, int key){
        // 哈希函数
        int hashAddress = key % hashLength;
        // 指定hashAddress对应值存在但不是关键值，则用开放寻址法解决
        while (hash[hashAddress] != 0 && hash[hashAddress] != key){
            hashAddress = (++hashAddress) % hashLength;
        }
        if (hash[hashAddress] == 0){
            return -1;
        }
        return hashAddress;

    }

    //数据插入Hash表
    public static void insertHash(int[] hash,int hashLength, int data){
        // 哈希函数
        int hashAddress = data % hashLength;
        // 如果key存在，则说明已经被别人占用，此时必须解决冲突
        while (hash[hashAddress] != 0){
            // 用开发寻址法找到
            hashAddress = (++hashAddress) % hashLength;
        }
        //将data存入字典中
        hash[hashAddress] = data;
    }

    public static void main(String[] args){
        int hashLength = 13;
        int[] array = {13,29,27,28,26,30,38};
        int[] hash = new int[hashLength];
        for (int i = 0;i < array.length;i++){
            insertHash(hash,hashLength,array[i]);
        }
        int result = searchHash(hash,hashLength,38);
        if (result != -1){
            System.out.println("已经在数组中找到，索引位置为："+result);
        }else {
            System.out.println("没有此数据");
        }

    }

}

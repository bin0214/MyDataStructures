package com.lyb.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: pz
 * Date: 2021/8/10
 * Time: 22:19
 * Description: No Description
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr); //调用插入排序算法
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;


        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            // 即arr[1]的前面这个数的下标
            insertIndex = i - 1;

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            arr[insertIndex + 1] = insertVal;
        }
    }
}

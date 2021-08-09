package com.lyb.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * User: pz
 * Date: 2021/8/9
 * Time: 23:38
 * Description: No Description
 */

//选择排序
public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j];
                    minIndex = j;
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}

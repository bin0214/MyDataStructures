package com.lyb.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: pz
 * Date: 2021/8/9
 * Time: 23:11
 * Description: No Description
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
        bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int [] arr){
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i ; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }
    }
}

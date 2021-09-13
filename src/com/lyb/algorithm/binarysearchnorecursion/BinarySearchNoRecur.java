package com.lyb.algorithm.binarysearchnorecursion;

/**
 * Created with IntelliJ IDEA.
 * User: pz
 * Date: 2021/9/13
 * Time: 22:45
 * Description: No Description
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, -3);
        System.out.println("index=" + index);//
    }

    //二分查找的非递归实现

    /**
     *
     * @param arr 待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length -1;

        while (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] < target){
                left  = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

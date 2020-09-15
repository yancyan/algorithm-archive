package com.demo.sort;

/**
 *  * 	依次确定元素，当确定arr[i]元素时，把它和以后的其他元素（arr[i+1] ~arr[arr.length-1]）比较，
 *  * 	中途有比他小的元素就进行交换，直到遍历到最后一个元素，确保是整个数组中最小的，结束。
 *  * 	冒泡排序交换比较多，而选择排序交换次数相对较少
 */
public class SelectionSort {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length -1 ; i++) {
            for ( int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

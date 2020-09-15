package com.demo.sort;

/**
 * 希尔排序基于插入排序，增加了新特性，提高插入排序的效率，
 * 该算法是冲破O(n2）的第一批算法之一
 */
public class ShellSort {
    public static void sort(int[] arr) {
        // 希尔增量
        int d = arr.length / 2;
        while (d >= 1) {               //增量为1时排序结束
            for (int k = 0; k < d; k++) {    //遍历所有的子序
                for (int i = k + d, j; i < arr.length; i += d) {  //对每个子序进行插入排序
                    int temp = arr[i];
                    for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j + 1] = temp;
                }
            }
            d = d / 2;                   //缩小增量
        }
    }

}

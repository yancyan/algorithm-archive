package com.demo.sort;

/**
 * 插入排序
 *
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1, j, current; i < arr.length; i++) {
            current = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > current; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 3, 2, 9, 23,4, 7};
        sort(ar);
        for (int i : ar) {
            System.out.print(i + ", ");
        }
    }
}

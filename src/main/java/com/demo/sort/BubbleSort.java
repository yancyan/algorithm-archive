package com.demo.sort;

import java.util.Collections;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = arr.length-1;  j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
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

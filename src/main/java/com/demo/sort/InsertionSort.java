package com.demo.sort;

public class InsertionSort {
    /**
     * 依次选择元素往前比较（往前为已经进行排序的元素），
     * 遇到比他小的元素停下并记住位置索引，迭代过的元素向后移动，然
     * 后插入这个元素到位置索引
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1]; //比较以为不满足就往后移动一位
                j--;
            }
            arr[j] = temp;
        }
    }
}


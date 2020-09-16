package com.demo.sort;

/**
 * * 算法思想：基于分治的思想，是冒泡排序的改进型。
 * * 首先在数组中选择一个基准点， 然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，
 * * 首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，
 * * 然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
 * * 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。
 * * 以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
 */
public class QuickSort {
    public static void sort(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        int key = arr[low];


        while (end > start) {
            //从后往前比较
            //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while (end > start && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //从前往后比较
            //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while (end > start && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) sort(arr, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(arr, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }
}

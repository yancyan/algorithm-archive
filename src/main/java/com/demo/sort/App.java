package com.demo.sort;

/**
 * *** 冒泡排序 / Bubble Sort
 * *** 插入排序 / Insertion Sort
 *
 * *** 归并排序 / Merge Sort
 * 快速排序 / Quick Sort
 * 拓扑排序 / Topological Sort
 *
 * 堆排序 Heap Sort
 * 桶排序 Bucket Sort
 *
 * 拓展：
 * 希尔排序（Shell Sort）
 * 选择排序（Selection Sort）
 * 快速排序（Quick Sort）
 * 计数排序（Counting Sort）
 * 基数排序（Radix Sort）
 */
public class App {

    public static void main(String[] args) {
        int[] ar = new int[]{1, 3, 2, 9, 23,4, 7};
        MergeSort.sort(ar);
        for (int i : ar) {
            System.out.print(i + ", ");
        }
    }
}

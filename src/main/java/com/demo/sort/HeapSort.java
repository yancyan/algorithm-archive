package com.demo.sort;

/**
 * 堆一般指的是二叉堆，二叉堆是完全二叉树或者近似完全二叉树
 * 一般用数组来表示堆，下标为 i 的结点的父结点下标为(i-1)/2；其左右子结点分别为 (2i + 1)、(2i + 2)
 *  *
 *  * 堆排序其实也是一种选择排序，是一种树形选择排序。只不过直接选择排序中，为了从R[1…n]中选择最大记录，需比较n-1次，
 *  * 然后从R[1…n-2]中选择最大记录需比较n-2次。事实上这n-2次比较中有很多已经在前面的n-1次比较中已经做过，
 *  * 而树形选择排序恰好利用树形的特点保存了部分前面的比较结果，因此可以减少比较次数。
 *  * 对于n个关键字序列，最坏情况下每个节点需比较log2(n)次，因此其最坏情况下时间复杂度为nlogn
 *
 *
 *  https://www.jianshu.com/p/11655047ab58
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {16,7,3,20,17,8};
        headSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


// ======================= 递归堆化
    public static void heap_sort(int[] arr, int n) {
        build_heap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    /**
     * @param arr 堆数组
     * @param n 构建堆的有效长度
     */
    public static void build_heap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    /**
     * 节点的堆化
     */
    private static void heapify(int[] arr, int lenght, int k) {
        if (k >= lenght) {
            return;
        }
        int c1 = 2 * k + 1;
        int c2 = 2 * k + 2;
        int max = k;
        if (c1 < lenght && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < lenght && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != k) {
            swap(arr, max, k);
            heapify(arr, lenght, max);
        }

    }
    private static void swap(int[] arr, int max, int k) {
        int temp = arr[k];
        arr[k] = arr[max];
        arr[max] = temp;
    }



// ======================= 循环
    /**
     * 堆排序
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }
    }
    private static void headAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }
}

package com.demo.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 查找给定数组中最大或最小的k个数
 *
 * @author ZhuYX
 * @date 2020/9/22 14:35
 */
public class TopK {

    public static void main(String[] args) {

        int[] ar = new int[]{1, 3, 2, 9, 23,4, 7};
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(topMaxK(ar, 3)));

    }

    /**
     *  小顶堆 PriorityQueue minHeap = new PriorityQueue<>();
     *  大顶堆 PriorityQueue maxHeap = new PriorityQueue<>(11, (i1, i2) -> i2 - i1);
     */
    public static int[] topMaxK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : arr) {
            if (pq.size() < k) {
                pq.offer(it);
            }
            else if (pq.peek() < it) {
                pq.poll();
                pq.offer(it);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}

package com.demo.dat.structure;

/**
 * 求最大公约数
 */
public class GreatestCommon {

    public static void main(String[] args) {
        int divisorV1 = getCommonDivisorV1(100, 80);
        System.out.println("############# " + divisorV1);

        int v = gcd(100, 80);
        System.out.println("############# " + v);
    }

    /**
     * 欧几里德算法，基于一个定理：两个正整数A和B（A > B）
     * 他们的最大公约数等于 A 除于 B的余数C 和B之间的最大公约数，
     */
    public static int getCommonDivisorV1(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        }
        return getCommonDivisorV1(max % min, min);
    }


    /**
     * 基于一个定理：两个正整数A和B（A > B）
     * 他们的最大公约数等于 A 减去 B的差值C 和B之间的最大公约数，
     */
    public static int getCommonDivisorV2(int a, int b) {
        if (a == b) {
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return getCommonDivisorV2(max - min, min);
    }

    /**
     * 移位运算的性能非常快。对于给定的正整数a和b，
     * 不难得到如下的结论。其中gcb(a,b)的意思是a,b的最大公约数函数：
     *
     * 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1)
     * 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)
     * 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
     * 当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)，
     * 此时a-b必然是偶数，又可以继续进行移位运算。

     */
    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        // A\B 都是偶数
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
        }
        //a是偶数，b是奇数
        else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
        }
        //a是奇数，b是偶数
        else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a, b >> 1);
        }
        else {
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            return gcd(big - small, small);
        }
    }
}

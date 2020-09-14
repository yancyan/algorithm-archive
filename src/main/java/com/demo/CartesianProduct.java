package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CartesianProduct {
    /**
     * 笛卡尔积中，
     * 子集列表中一个元素重复的个数是这个列表右侧列表的size乘积
     * 子集列表循环次数为这个列表左侧列表的size乘积
     * @param inputs
     * @param result
     */
    public static void cartesianProduct(List<List<String>> inputs, List<List<String>> result) {
        int total = 1;
        for (List<String> ips : inputs) {
            total *= ips.size();
        }
        int now = 1;
        int loopNum = 1;
        int itemLoopNum = 1;

        String[] resultArr = new String[total];
        for (List<String> input : inputs) {
            now *= input.size();
            int currentSize = input.size();
            // 子集元素重复次数
            loopNum = total / now;
            // 子集循环次数   itemLoopNum = total / (loopNum * currentSize);
            itemLoopNum = now / currentSize;

            // 遍历子集的游标
            int dataCursor = 0;
            int index = 0;
            for (String item : input) {
                for (int i = 0; i < itemLoopNum; i++) {
                    if (dataCursor == input.size()) {
                        dataCursor = 0;
                    }
                    for (int i1 = 0; i1 < loopNum; i1++) {
                        resultArr[index] = (resultArr[index] == null? "" : resultArr[index] + ",") + input.get(dataCursor);
                        index++;
                    }
                    dataCursor++;
                }
            }

        }

        for (String string : resultArr) {
            String[] stringArray = string.split(",");
            result.add(Arrays.asList(stringArray));
        }
    }

    public static void main (String[] args) {
        List<List<String>> inputs = getLists();

        List<List<String>> circulateResult = new ArrayList<List<String>>();
        cartesianProduct(inputs, circulateResult);
        System.out.println("Result Count Num: " + circulateResult.size());
        for (List<String> list : circulateResult) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> getLists() {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        List<String> list3 = new ArrayList<String>();
        list3.add("x");
        list3.add("y");
        list3.add("z");
        list3.add("k");
        List<List<String>> dimValue = new ArrayList<List<String>>();
        dimValue.add(list1);
        dimValue.add(list2);
        dimValue.add(list3);
        return dimValue;
    }
}


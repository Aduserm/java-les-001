package com.zeroten.javales001.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortUtils {
    private static void bubbleSort(List<Integer> list) {
        System.out.println("输入：" + list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // 如果前边的数大于后边的数，交换位置
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        System.out.println("冒泡排序后：" + list);
    }

    private static void insertionSort(List<Integer> list) {
        System.out.println("输入：" + list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int num = list.get(i);
            int j = i - 1;
            for (; j >= 0; j--) {
                if (list.get(j) > num) {
                    list.set(j + 1, list.get(j));
                } else {
                    break;
                }
            }
            list.set(j + 1, num);
        }
        System.out.println("插入排序后：" + list);
    }

    public static void selectionInsert(List<Integer> list) {
        System.out.println("输入：" + list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, tmp);
            }
        }
        System.out.println("选择排序后：" + list);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        fillRandom(list, 10);
        // bubbleSort(list);
        // insertionSort(list);
        selectionInsert(list);
    }

    private static void fillRandom(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(new Random().nextInt(100));
        }
    }
}

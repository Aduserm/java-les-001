package com.zeroten.javales001.list;

import java.util.*;

public class ListStudy {
    // List 主要有两种：ArrayList 和 LinkedList
    // ArrayList：内部是使用数组来实现的
    // LinkedList：内部使用的是一个双向链表来实现
    // 创建：无参数构建；有参数构造 1指定容量大小 2复制已存在的List来创建
    // 添加：1 头插；2 尾插；3 中间插入
    // 删除：1 头删；2 尾删；3 中间删除
    // 遍历：
    //   1：使用 for 循环
    //   2：使用迭代器 Iterator，ListIterator
    //   3：使用迭代器对 List 进行添加、删除操作
    //   4：迭代器的使用注意事项：在使用迭代器对列表进行操作时，
    //      原对象不能发生结构性变化（add/remove等），否则迭代器操作会抛异常。通过 modCount 计数来实现
    //      如果原对象发生结构性变化，需要重新获取迭代器
    // 底层实现原理及主要JDK源码：内部存储结构、添加/删除/遍历操作的流程
    // 对 List 进行排序：冒泡、插入、选择

    private static void addNumberToList(List<Integer> list, int count, int number) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(number);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    private static void studyArrayListOp() {
        // 创建ArrayList时，如果为指定容量大小，则会创建一个空数组。
        // 第一次调用 add 方法时，将容量扩充为默认容量大小 DEFAULT_CAPACITY
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        int count = 2000000;
        System.out.println("list1=" + list1);
        list1.add(0, 100);
        System.out.println("list1=" + list1);
        list1.add(3, 20);
        System.out.println("list1=" + list1);
        list1.set(2, 33);
        // addNumberToList(list1, count, 1);
        System.out.println("list1=" + list1);

        // 删除
        list1.remove(1);
        System.out.println("list1=" + list1);
        list1.remove(list1.size() - 1);
        System.out.println("list1=" + list1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Integer num : list1) {
            System.out.println(num);
        }

        // 如果在创建 ArrayList 时，能预估数据规模，
        // 我们就可以指定一个初始容量大小，以减少扩容操作
        List<Integer> list2 = new ArrayList<>(count);
        // addNumberToList(list2, count, 1);
        //for (Integer n : list1) {
        //    list2.add(n);
        //}
        // System.out.println("list2=" + list2);

        // 数组是有容量大小限制，当 add 操作时，如果数组已满，就会引发扩容
        // 1. 计算新的容量大小：原来容量的1.5倍
        // 2. 按新的容量大小创建一个新的数组
        // 3. 将旧的数组里的元素全部复制到新创建的数组中
        // 4. 丢弃旧的数组
    }

    private static void listIterator() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        ListIterator<String> listIterator = list.listIterator();
//        System.out.println("hasPrevious=" + listIterator.hasPrevious());
//        System.out.println("hasNext=" + listIterator.hasNext());
//        System.out.println("previousIndex=" + listIterator.previousIndex());
//        System.out.println("nextIndex=" + listIterator.nextIndex());
//
//        // listIterator.previous();
//        System.out.println("next()=" + listIterator.next());
//        System.out.println("hasPrevious=" + listIterator.hasPrevious());
//        System.out.println("hasNext=" + listIterator.hasNext());
//        System.out.println("previousIndex=" + listIterator.previousIndex());
//        System.out.println("nextIndex=" + listIterator.nextIndex());
//
//        System.out.println(list);
//        listIterator.set("A-Update");
//        System.out.println(list);
//        listIterator.add("A-New");
//        System.out.println(list);
//
//        System.out.println("previous=" + listIterator.previous());
//        // System.out.println("next=" + listIterator.next());
//        listIterator.set("A-Update2");
//        System.out.println(list);
//
//        listIterator.remove();
//        System.out.println(list);
//
//        System.out.println("next=" + listIterator.next());
//        listIterator.remove();
//        System.out.println(list);

        // 迭代器操作元素的时候，
        // set 和 remove 方法和迭代器的状态有关，更新或者删除的是上一次调用 next 或者 previous 方法返回的元素
        // add 只和迭代器的位置有关，在当前迭代器位置之前添加元素
//        System.out.println(list);
//        listIterator.next();
//        listIterator.next();
//
//        System.out.println("previous=" + listIterator.previous());
//        // listIterator.set("Update");
//        listIterator.add("New1");
//        listIterator.add("New2");
//        System.out.println(list);

        System.out.println(listIterator.next());
        list.add("D"); // modCount++
        list.set(1, "B1"); // 修改原值，不属于结构化修改
        // listIterator = list.listIterator();
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());

    }

    public static void studyLinkedList() {
        // 链表，创建的时候不需要指定容量大小，因为它没有大小限制
        List list1 = new LinkedList();
        list1.add("A");
        list1.add("B");
        System.out.println(list1);

        List list2 = new LinkedList(list1);
        System.out.println(list1);

        System.out.println(list1.get(1));
    }

    private static void listOpTime(List<Integer> list) {
        int times = 100000;

        // for 循环遍历
        // 对于 LinkedList 每次 get(index)，都会从头开始查找
        // 优化：如果 i > length / 2 时，从尾部开始查找
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.printf("[%s] for循环遍历耗时 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis() - start);

        // Iterator
        start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
        }
        System.out.printf("[%s] 迭代器循环遍历耗时 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis() - start);

        // for-each
        start = System.currentTimeMillis();
        for (Integer n : list) {
        }
        System.out.printf("[%s] for-each循环遍历耗时 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis() - start);

        // 在第5位插入 10000 个 1
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            list.add(4, 1);
        }
        System.out.printf("[%s] 第5位插入 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis() - start);

        // 在末尾插入 10000 个 2
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            list.add(2);
        }
        System.out.printf("[%s] 末尾插入 %dms\n", list.getClass().getSimpleName(), System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        // studyArrayListOp();
        // listIterator();
        // studyLinkedList();
        // ArrayList 和 LinkedList 区别
        // ArrayList 长于随机快速访问，而从列表中间删除/插入元素很慢
        // LinkedList 长于从列表中间删除/插入元素，但随机访问很慢
        // 随机访问：list.get(index)，通过索引来访问

        List<Integer> list = new ArrayList<>();
        fill(list);
        listOpTime(list);

        List<Integer> list2 = new LinkedList<>();
        fill(list2);
        listOpTime(list2);
    }

    private static void fill(List<Integer> list) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }
}

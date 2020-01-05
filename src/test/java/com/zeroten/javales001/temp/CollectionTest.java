package com.zeroten.javales001.temp;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CollectionTest {
    @Test
    public void testQueue() {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

//        System.out.println(queue.removeLast());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        LinkedList<String> queueList = new LinkedList<>();
        queueList.add("a");
        queueList.add("b");
        queueList.add("c");

        System.out.println(queueList.remove());
        System.out.println(queueList.remove());
        System.out.println(queueList.remove());
    }
}

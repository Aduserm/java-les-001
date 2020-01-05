package com.zeroten.javales001.collection;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("B");
        list.add("C");
        System.out.println(list);

        list.remove("B");
        System.out.println(list);
    }
}

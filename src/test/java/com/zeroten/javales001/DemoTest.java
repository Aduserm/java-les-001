package com.zeroten.javales001;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Random;

public class DemoTest {

    public static void main(String[] args) {
        // n次幂
        int multiple = 0;
        // 长度
        int length;
        // 不成立的次数
        int fail = 0;
        while (true) {
            length = (int) Math.pow(2, ++multiple);
            if (length >= Integer.MAX_VALUE) {
                break;
            }
            // 随机生成一个正整数
            int num = new Random().nextInt(Integer.MAX_VALUE - 1);
            // 判断等式是否成立
            if ((num & (length - 1)) != num % length) {
                fail++;
            } else {
                System.out.printf("2的%d次幂，length=2^%d=%d，转换成二进制：length=%s,length-1=%s\n",
                        multiple, multiple, length, Integer.toBinaryString(length), Integer.toBinaryString(length - 1));
            }
        }
        if (fail == 0) {
            System.out.printf("当 length 为 2 的次幂时，num & (length - 1) = num %s length 等式成立, 最大%d次幂\n",
                    "%", multiple - 1);
        }
    }

    @Test
    public void printBin() {
        System.out.println(0b10000);
    }

    @Test
    public void testBin() {
        // System.out.println(0b1111);
        // System.out.println(Math.pow(2, 3));
        int ret = tableSizeFor(-1);
        System.out.println();
        System.out.println("结果：" + ret);
        printBin(ret);

        // System.out.println(Integer.toBinaryString(256));
    }

    @Test
    public void testPrint() {
        // num & (length - 1) = num % length
        long start = System.nanoTime();
        int num = new Random().nextInt(10000);
        int length = 16;
        int len = length - 1;
        for (int n = 0; n < 10000000; n++) {
            int index = num & len;
        }
        long ns = System.nanoTime() - start;
        System.out.printf("耗时: %dns\n", ns);

        start = System.nanoTime();
        for (int n = 0; n < 10000000; n++) {
            int index = num % length;
        }
        ns = System.nanoTime() - start;
        System.out.printf("耗时: %dns\n", ns);

        //System.out.println(calc(3));
        //System.out.println(calc(5));
        //System.out.println(calc(11));
    }

    public int tableSizeFor(int cap) {
        int n = cap - 1;

        printStr("【n |= n >>> 1】");
        printBin(cap - 1);
        printBin(n >>> 1);
        n |= n >>> 1;
        printSeq();
        printBin(n);

        printStr("【n |= n >>> 2】");
        printBin(n);
        printBin(n >>> 2);
        n |= n >>> 2;
        printSeq();
        printBin(n);

        printStr("【n |= n >>> 4】");
        printBin(n);
        printBin(n >>> 4);
        n |= n >>> 4;
        printSeq();
        printBin(n);

        printStr("【n |= n >>> 8】");
        printBin(n);
        printBin(n >>> 8);
        n |= n >>> 8;
        printSeq();
        printBin(n);

        printStr("【n |= n >>> 16】");
        printBin(n);
        printBin(n >>> 16);
        n |= n >>> 16;
        printSeq();
        printBin(n);

        return n + 1;
    }

    private void printStr(String str) {
        System.out.println(str);
    }

    private void printSeq() {
        System.out.println("  --------");
    }

    private void printBin(int num) {
        System.out.println(String.format("  %8s", Integer.toBinaryString(num >>> 1)));
    }

}

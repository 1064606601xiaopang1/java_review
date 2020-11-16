package com.review;

import org.junit.Test;

/**
 * @Author: Guo
 * @Date: 2020/11/16 11:12
 * @Name: java_demo_review
 * explain：==与equals之间的比较
 */
public class TestEquals {
    public static void main(String[] args) {
        test();
        test2();
    }

    /**
     * ==在基本类型中的使用
     * byte,short int long float double boolean char
     */
    public static void test() {
        // == 在基本数据类型中比较的是他们之间的值
        int i = 1;
        int i1 = 1;
        char c = '1';
        System.out.println(i == i1); // true
        System.out.println(i == c); //false
    }

    /**
     * == 地址是否相等
     * equals比较的是内容是否相等
     */
    public static void test2() {
        String a = "北京欢迎你";
        String b = "北京欢迎你";
        String c = new String("北京欢迎你");
        System.out.println(a == b);// true
        System.out.println(b == c);// false
        // true 前提是b.hashCode() = c.hashCode()必须相等才会返回true
        System.out.println(b.equals(c));
        int i = b.hashCode();
        int i1 = a.hashCode();
        int i2 = c.hashCode();
        // -1203112609_______-1203112609___-1203112609
        System.out.println(i + "_______" + i1 + "___" + i2);
    }

    @Test
    public void test3() {
        System.out.println(3 * 0.1 == 0.3);
        byte a = 1;
        byte b = 1;
        a += b;
        a = (byte) (a + b);  // a+b会将byte隐式的转换为int类型  所以需要强转回来byte
        System.out.println("a = " + a);

        short s1= 1;
        s1 += 1;
//        s1 = (short)(s1 + 1);
        System.out.println("s1 = " + s1);
    }
}

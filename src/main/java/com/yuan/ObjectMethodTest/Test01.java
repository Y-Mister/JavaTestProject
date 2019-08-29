package com.yuan.ObjectMethodTest;

/**
 * Author:yuanhang
 * Date:2019-08-29 9:48
 * Description:<描述>
 */
public class Test01 {
    private int num;

    public Test01(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Test01{" +
                "num=" + num +
                '}';
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01(1);
        Test01 test02 = new Test01(2);
        Test01 test03 = new Test01(3);
        System.out.println(test01.hashCode());

        System.out.println();
    }
}

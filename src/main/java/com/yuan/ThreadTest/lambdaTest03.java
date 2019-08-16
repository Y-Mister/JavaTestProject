package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 20:40
 * Description:<描述>
 */
public class lambdaTest03 {


    public static void main(String[] args) {
        //简化形式1
        IInterset interest = (int a,int b) -> {
            System.out.println("i am interseted in-->"+a+"+"+b);
            return a+b;
        };
        int sum = interest.lambda(1,1);
        System.out.println("a+b="+sum);

        //简化形式2，省略类型，但括号不能省
        interest = (a,b) -> {
            System.out.println("i am interseted in-->"+a+"+"+b);
            return a+b;
        };
        sum = interest.lambda(1,10);
        System.out.println("a+b="+sum);

        //简化形式3，只有一行return时，可以省略花括号与return
        interest = (a,b)->a+b;
        sum = interest.lambda(5, 5);
        System.out.println("a+b="+sum);
    }


}


interface IInterset{
    int  lambda(int a,int b);
}

//外部类形式，作简化lambda的参考
class Interest implements IInterset{

    @Override
    public int lambda(int a, int b) {
        System.out.println("i am interseted in-->"+a+"+"+b);
        return a+b;
    }
}
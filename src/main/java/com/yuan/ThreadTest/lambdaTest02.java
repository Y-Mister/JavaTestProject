package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 20:34
 * Description:<描述>
 */
public class lambdaTest02 {

    public static void main(String[] args) {
        ILove love = (int a)->{
            System.out.println("I love lambda-->"+a);
        };
        love.lamba(100);

        //简化
        love = (a)->{
            System.out.println("I love lambda-->"+a);
        };
        love.lamba(50);
        //只有一个参数时，括号也可以省略
        love = a->{
            System.out.println("I love lambda-->"+a);
        };
        love.lamba(25);
        //如果程序体只有一行代码，还可以继续省略
        love = a-> System.out.println("I love lambda-->"+a);
        love.lamba(10);
    }
}

interface ILove{
    void lamba(int a);

}
/*外部类，作参考用*/
class Love implements ILove{


    @Override
    public void lamba(int a) {
        System.out.println("I love lambda-->"+a);
    }
}

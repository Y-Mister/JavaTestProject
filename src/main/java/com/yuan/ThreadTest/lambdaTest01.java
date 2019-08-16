package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 17:17
 * Description:
 * lambda推导过程
 */
public class lambdaTest01 {

    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }


    public static void main(String[] args) {
        /*1.外部类*/
        ILike like = new Like();
        like.lambda();

        /*2.静态内部类*/
        ILike like2 = new Like2();
        like2.lambda();


        /*3.方法内部类*/
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        ILike like3 = new Like3();
        like3.lambda();



        /*4.匿名内部类*/
        ILike like4 = new ILike(){

            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like4.lambda();

        /*4.使用lambda简化*/
        ILike like5 = ()->{
                System.out.println("i like lambda5");
        };
        like5.lambda();

        /**
         * lambda推导必须存在类型，他需要根据你所赋给的对象来进行推导
         * ()->{
             System.out.println("i like lambda5");
             };
             like5.lambda();
         */
    }
}

interface ILike{
    void lambda();

}

class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda1");
    }
}

package com.yuan.DesignMode;

/**
 * Author:helloboy
 * Date:2019-07-23 21:56
 * Description:Drink为顶层接口，coffee与Decorate均实现该接口；而sugar、milk继承Decorate简介实现Drink接口
 */
public class DecorateTest02 {

    public static void main(String[] args) {
            Drink coffee = new Coffee();
            Drink sugar = new Sugar(coffee);
            System.out.println(sugar.info()+"---"+sugar.cost()+"元");
            /*Drink milk = new Milk(coffee);
            System.out.println(milk.info()+"---"+milk.cost()+"元");*/
            Drink milk = new Milk(sugar);
            System.out.println(milk.info()+"--->"+milk.cost()+"元");
    }
}
//抽象组件
interface Drink{
    double cost();
    String info();
}
//具体组件
class Coffee implements Drink{

    private String name="卡布奇诺";
    @Override
    public double cost() {
        return 25;
    }

    @Override
    public String info() {
        return name;
    }
}

//抽象的装饰类
abstract class Decorate implements Drink{
    //对抽象组件的引用
    private Drink drink;

    Decorate(Drink drink){
        this.drink = drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

//具体装饰类
class Milk extends Decorate{


    Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加奶";
    }
}

class Sugar extends Decorate{


    Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()+2;
    }

    @Override
    public String info() {
        return super.info()+"加糖";
    }
}
package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-03 21:41
 * Description:<描述>
 */
public class unsafe02 {

    public static void main(String[] args) {
        Account account = new Account(100,"储蓄金");
        Drawing husband = new Drawing(account,80,"老公");
        Drawing wife = new Drawing(account,90,"妻子");
        husband.start();
        wife.start();
    }

}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟提款

class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int pocketMoney;//取钱总数
    @Override
    public void run() {
        if (account.money<0){
            System.out.println("余额不足，无法取钱");
            return;
        }


            pocketMoney+=drawingMoney;
            account.money-=drawingMoney;
            System.out.println(this.getName()+"-->账户余额为"+account.money);
            System.out.println(this.getName()+"-->口袋里有钱"+pocketMoney);


    }

    public Drawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
}
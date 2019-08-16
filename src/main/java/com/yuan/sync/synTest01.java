package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-04 9:02
 * Description:<描述>
 */
public class synTest01 {

    public static void main(String[] args) {
        Account account = new Account(100,"储蓄金");
        SynDrawing husband = new SynDrawing(account,80,"老公");
        SynDrawing wife = new SynDrawing(account,90,"妻子");
        husband.start();
        wife.start();
    }
}

class SynDrawing extends Thread{
    Account account;
    int drawingMoney;
    int pocketMoney;//取钱总数
    @Override
    public void run() {
        test();
    }
    //这里使用同步块锁定account，
    private  void test(){

        synchronized(account){
            if (account.money-drawingMoney<0){
                System.out.println("余额不足，无法取钱");
                return;
            }

            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            pocketMoney+=drawingMoney;
            account.money-=drawingMoney;
            System.out.println(this.getName()+"-->账户余额为"+account.money);
            System.out.println(this.getName()+"-->口袋里有钱"+pocketMoney);
        }

    }

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
}
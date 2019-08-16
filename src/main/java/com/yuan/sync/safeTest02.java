package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-03 22:34
 * Description:<描述>
 */
public class safeTest02 {

    public static void main(String[] args) {
        Account account = new Account(100,"储蓄金");
        SafeDrawing husband = new SafeDrawing(account,80,"老公");
        SafeDrawing wife = new SafeDrawing(account,90,"妻子");
        husband.start();
        wife.start();
    }
}



class SafeDrawing extends Thread{
    Account account;
    int drawingMoney;
    int pocketMoney;//取钱总数
    @Override
    public void run() {
        test();
    }
    //这里锁定失败，因为这里需要对是对account中的数据进行操作，
    private synchronized void test(){
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

    public SafeDrawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
}

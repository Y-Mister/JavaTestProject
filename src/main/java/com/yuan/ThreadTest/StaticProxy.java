package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 16:55
 * Description:静态代理
 * 公共接口：
 * 1.真实角色
 * 2.代理角色
 */
public class StaticProxy {

    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        // new Thread(线程对象).start();
    }

}

interface Marry{
    void happyMarry();
}
//真是角色
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("你和嫦娥终于奔月了");
    }
}

//代理角色
class WeddingCompany implements Marry{

    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        target.happyMarry();
        after();
    }

    private void before(){
        System.out.println("布置环境");
    }
    private void after(){
        System.out.println("撤出环境");
    }
}
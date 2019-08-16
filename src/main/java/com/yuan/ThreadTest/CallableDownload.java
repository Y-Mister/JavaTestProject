package com.yuan.ThreadTest;

import java.util.concurrent.*;

/**
 * Author:helloboy
 * Date:2019-08-01 15:32
 * Description:<描述>
 */
public class CallableDownload implements Callable<Boolean> {
    private String url;
    private String name;

    public CallableDownload(String url, String name1) {
        this.url = url;
        name = name1;
    }

    @Override
    public Boolean call() throws Exception{
        WebDownLoader wd = new WebDownLoader();
        wd.download(url,name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDownload cd1 = new CallableDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564655192199&di=e264f3e79523622b974f334589897995&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160526%2F532990bf2c884450b873b1e3b211a87a_th.jpg","downloadPic/bilibili01.jpg");
        CallableDownload cd2 = new CallableDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564655192198&di=8573b8d470e95939084eb0d0d6f12c1e&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201602%2F21%2F20160221161052_raFAG.jpeg","downloadPic/bilibili02.jpg");
        CallableDownload cd3 = new CallableDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564655192198&di=b3cb156fff7969b511570d655b73bc42&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201809%2F15%2F20180915214707_xyowd.jpg","downloadPic/bilibili03.jpg");

        /*//创建执行服务
        ExecutorService ser = new Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = ser.submit(cd1);
        Future<Boolean> result2 = ser.submit(cd2);
        Future<Boolean> result3 = ser.submit(cd3);

        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        //关闭服务
        ser.shutdownNow();*/



    }
}

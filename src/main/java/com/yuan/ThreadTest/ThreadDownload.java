package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 15:32
 * Description:<描述>
 */
public class ThreadDownload extends Thread {
    private String url;
    private String name;

    public ThreadDownload(String url, String name1) {
        this.url = url;
        name = name1;
    }

    @Override
    public void run() {
        WebDownLoader wd = new WebDownLoader();
        wd.download(url,name);
    }

    public static void main(String[] args) {
        ThreadDownload td1 = new ThreadDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564655192199&di=e264f3e79523622b974f334589897995&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160526%2F532990bf2c884450b873b1e3b211a87a_th.jpg","downloadPic/bilibili01.jpg");
        ThreadDownload td2 = new ThreadDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564655192198&di=8573b8d470e95939084eb0d0d6f12c1e&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201602%2F21%2F20160221161052_raFAG.jpeg","downloadPic/bilibili02.jpg");
        ThreadDownload td3 = new ThreadDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564655192198&di=b3cb156fff7969b511570d655b73bc42&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201809%2F15%2F20180915214707_xyowd.jpg","downloadPic/bilibili03.jpg");

        td1.start();
        td2.start();
        td3.start();
    }
}

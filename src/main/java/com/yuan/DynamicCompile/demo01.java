package com.yuan.DynamicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by 朱承才 on 2019/8/18.
 */
public class demo01 {

    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /**
         * 参数一：通常是一个输入流
         * 参数二：通常是一个输出流
         * 参数三：通常是一个错误输出流
         * 参数四：待编译类的classPath
         */
        int result = compiler.run(null,null,null,"D:/yuanHang/myJava/helloWorld.java");
        System.out.println(result==0?"编译成功":"编译失败");

        //通过Runtime启动新线程动态运行编译好的类
        /*Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -cp D:/yuanHang/myJava/ helloWorld");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String str;
        while ((str = reader.readLine())!=null){
            System.out.println(str);
        }*/

        //通过反射和类加载器动态加载类
        URL[] urls = new URL[]{new URL("file:/"+"D:/yuanHang/myJava/")};
        URLClassLoader loader = new URLClassLoader(urls);
        try {
            Class c = loader.loadClass("helloWorld");
            c.getMethod("main",String[].class).invoke(null, (Object) new String[]{"aa","bb"});//此处若不加Object强转,则传入参数将变成"aa","bb"而不是一个字符串数组
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        /*如果想对该字符串进行动态编译，可以需要将其存储成一个临时文件，然后调用动态编译*/
        /*String str = "public class Hi{public static void main(String[] args){System.out.println(\"Hi\");}}}";
        File file = new File("testDynamicCompile.java");
        byte[] bytes = str.getBytes();
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bytes,0,bytes.length-1);
        outputStream.flush();
        outputStream.close();
        int result2 = compiler.run(null,null,null,"testDynamicCompile.java");
        System.out.println(result2==0?"编译成功":"编译失败");*/
    }
}

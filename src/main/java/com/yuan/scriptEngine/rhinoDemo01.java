package com.yuan.scriptEngine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

;

/**
 * Created by 朱承才 on 2019/8/19.
 *测试脚本引擎
 */
public class rhinoDemo01 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量
        engine.put("msg","a good man!");
        System.out.println(engine.get("msg"));
        String str = "var user={name:'gaoqi',age:18,schools:['清华大学','sxt']};";
        str+="print(user.name);";

        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'good school';");
        System.out.println(engine.get("msg"));
        System.out.println("----------------------------");

        //定义函数
        engine.eval("function add(a,b){var sum = a+b;return sum;}");
        //取得函数调用接口
        Invocable jsInvoke = (Invocable)engine;
        //执行脚本中定义的方法
        Object result = jsInvoke.invokeFunction("add", new Object[]{13, 20});
        System.out.println(result);

        //导入其他java包，使用其他包中的java类
        String jsCode = "  var list = java.util.Arrays.asList([\"sxt\",\"xts\",\"tsx\"]);";
        engine.eval(jsCode);

        List<String> list2 = (List<String>) engine.get("list");
        for (String temp:list2){
            System.out.println(temp);
        }

        //执行一个js文件，将a.js放在src目录下即可   视频中的方法无法使用
        rhinoDemo01.class.getClassLoader().getResources("a.js");
        FileReader fileReader = new FileReader(rhinoDemo01.class.getClassLoader().getResources("a.js").toString());
        engine.eval(fileReader);
        fileReader.close();

    }

}

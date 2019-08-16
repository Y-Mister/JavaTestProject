package com.yuan.CollectionTest;

import java.util.Map;
import java.util.TreeMap;

/**
 * Author:helloboy
 * Date:2019-07-22 15:03
 * Description:<描述>
 */
public class TreeMapUser {

    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<>();
        map.put(20,"aa");
        map.put(3,"bb");
        map.put(6,"cc");
        //按照Key自增的方式排序
        for (Integer key:map.keySet()){
            System.out.println(key+": "+map.get(key));
        }

        Map<Employ,String> emp = new TreeMap<>();
        emp.put(new Employ(100,"ads",50000),"ads是个好小伙");
        emp.put(new Employ(200,"asadf",6000),"asadf不是个好小伙");
        emp.put(new Employ(150,"asadf2",6000),"asadf2不是个好小伙2");
        emp.put(new Employ(300,"adfe",1500),"adfe是个开心果");

        for (Employ ppp:emp.keySet()){
            System.out.println(ppp+":"+emp.get(ppp));
        }
    }

    static class Employ implements Comparable<Employ>{
        int id;
        String name;
        double salary;

        public Employ(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employ{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public int compareTo(Employ o) {//复数小于，正数大于，0等于
            if (this.salary>o.salary){
                return 1;
            }else if (this.salary<o.salary){
                return -1;
            }else{
                if (this.id>o.id){
                    return 1;
                } else if (this.id<o.id){
                    return -1;
                } else if (this.id>o.id){
                    return 0;
                }
            }
            return 0;
        }
    }

}

package com.yuan.MyTest;

/**
 * Author:helloboy
 * Date:2019-08-05 9:40
 * Description:<描述>
 */
public class enumTest {
    public static void main(String[] args) {
        DBConnection conn1 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection conn2 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection conn3 = DataSourceEnum.MYENUM.getConnection();
        DBConnection conn4 = DataSourceEnum.MYENUM.getConnection();

        System.out.println(conn1 == conn2);
        System.out.println(conn2 == conn3);
        System.out.println(conn4 == conn3);

    }


}

enum  DataSourceEnum {
    DATASOURCE,MYENUM;
    private DBConnection connection = null;
    private DataSourceEnum(){
        connection = new DBConnection();
        System.out.println("枚举初始化");
    }
    public DBConnection getConnection(){
        return connection;
    }

}

class DBConnection {

}

package com.yuan.Annotation;

/**
 * Author:袁航
 * Date:2019-08-11 22:02
 * Description:<描述>
 */
@StuTable(value = "tb_student")
public class RefStudent {
    @stuField(columnName = "id",type = "int",length = 10)
    private int id;
    @stuField(columnName = "sname",type = "varchar",length = 10)
    private String studentName;
    @stuField(columnName = "age",type = "int",length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

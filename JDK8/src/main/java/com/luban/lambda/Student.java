package com.luban.lambda;

public class Student {

    private String Name;
    private Integer age;
    private String sex;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, Integer age, String sex) {
        Name = name;
        this.age = age;
        this.sex = sex;
    }
}

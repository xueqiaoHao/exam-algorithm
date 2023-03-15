package com.course.interview_01;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/7 17:02
 */
public class User {
    private String name;
    User(String name){
        this.name=name;
    }

    private String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        User user = (User)obj;
        return user.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

package com.test.spring5;

/**
 * @author wanyu
 * @createTime 2022-03-13 1:48
 */
public class User {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void add(){
        System.out.println("add");
    }


}

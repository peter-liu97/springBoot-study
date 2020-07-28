package com.test;

public class User {

    private Integer userId;
    private String userType;
    private double bargain;

    public double getBargain() {
        return bargain;
    }

    public void setBargain(double bargain) {
        this.bargain = bargain;
    }


    public User(Integer userId, String userType, double bargain) {
        this.userId = userId;
        this.userType = userType;
        this.bargain = bargain;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

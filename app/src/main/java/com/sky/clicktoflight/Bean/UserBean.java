package com.sky.clicktoflight.Bean;

public class UserBean {
    private int uId;
    private String uName;
    private String uPwd;
    private String imagePath;

    @Override
    public String toString() {
        return "UserBean{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public UserBean(int uId, String uName, String uPwd, String imagePath) {
        this.uId = uId;
        this.uName = uName;
        this.uPwd = uPwd;
        this.imagePath = imagePath;
    }

    public UserBean() {
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

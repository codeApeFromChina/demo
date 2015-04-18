package cn.tj.fnzi.mis.service;


public class User {

    private Integer userId;
    private String userName;
    private String userPwd;
    private String userRemark;
    private String userDate;
    private String userLastIp;
    private String userLastTime;

    public User() {
    }

    public User(String userPwd, String userDate) {
        this.userPwd = userPwd;
        this.userDate = userDate;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return this.userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRemark() {
        return this.userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getUserDate() {
        return this.userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserLastIp() {
        return userLastIp;
    }

    public void setUserLastIp(String userLastIp) {
        this.userLastIp = userLastIp;
    }

    public String getUserLastTime() {
        return userLastTime;
    }

    public void setUserLastTime(String userLastTime) {
        this.userLastTime = userLastTime;
    }
}
package com.bdec.spring_web.async_demo;

import java.util.List;

public class UserListAndTimings {
    private List<User> userList;
    private Long totalTime;

    public UserListAndTimings() {
    }

    public UserListAndTimings(List<User> userList, Long totalTime) {
        this.userList = userList;
        this.totalTime = totalTime;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }
}

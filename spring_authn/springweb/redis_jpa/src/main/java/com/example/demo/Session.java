package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@RedisHash("session")
public class Session implements Serializable {
    @Id
    private Integer userId;
    private String sessionCookie;
    private Date sessionExpire;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", sessionCookie='" + sessionCookie + '\'' +
                ", sessionExpire=" + sessionExpire +
                '}';
    }

    public Session() {
    }

    public Session(Integer userId, String sessionCookie, Date sessionExpire) {
        this.userId = userId;
        this.sessionCookie = sessionCookie;
        this.sessionExpire = sessionExpire;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSessionCookie() {
        return sessionCookie;
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    public Date getSessionExpire() {
        return sessionExpire;
    }

    public void setSessionExpire(Date sessionExpire) {
        this.sessionExpire = sessionExpire;
    }
}

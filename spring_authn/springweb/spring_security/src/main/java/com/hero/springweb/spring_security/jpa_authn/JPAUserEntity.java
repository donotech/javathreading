package com.hero.springweb.spring_security.jpa_authn;


import javax.persistence.*;

@Entity
@Table(name = "jpa_user_table")
public class JPAUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String password;

    public JPAUserEntity() {
    }

    public JPAUserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

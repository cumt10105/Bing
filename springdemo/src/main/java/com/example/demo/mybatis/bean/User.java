package com.example.demo.mybatis.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = -5725043477268101740l;
    private String id;

    private String name;

    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginDateTime() {
        return loginDateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginDateTime='" + loginDateTime + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public void setLoginDateTime(String loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String loginDateTime;

    private String comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


}

package com.company.Shop.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;


@XmlRootElement(name="coWorker")
@XmlAccessorType(XmlAccessType.FIELD)
public class CoWorker {
    private int id;
    private String name;
    private String login;
    private String password;
    private LocalDateTime createdTime;

    public CoWorker() {
    }

    public CoWorker(int id, String name, String login,
                    String password, LocalDateTime createdTime) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}

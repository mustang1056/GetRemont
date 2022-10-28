package com.auto.getremont.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


public class User {


    private Long id;
    private String name;
    private String login;
    private char[] pswd;

    private String image;

    public String getImage() {
        return image;
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

    public char[] getPswd() {
        return pswd;
    }

    public void setPswd(char[] pswd) {
        this.pswd = pswd;
    }
}

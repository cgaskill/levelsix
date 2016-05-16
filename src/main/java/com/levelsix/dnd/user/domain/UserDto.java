package com.levelsix.dnd.user.domain;

/**
 * Created by cgaskill on 5/14/16.
 */
public class UserDto {
    // TODO add validation checking
    private String email;
    private String name;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

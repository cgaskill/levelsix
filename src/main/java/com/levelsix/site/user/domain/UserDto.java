package com.levelsix.site.user.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by cgaskill on 5/14/16.
 */
public class UserDto {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String name;
    @Min(value = 5)
    @NotNull
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
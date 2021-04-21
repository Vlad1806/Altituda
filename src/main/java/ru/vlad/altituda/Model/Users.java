package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Email
    @NotEmpty
    @Size(max = 100,message = "Это поле не должно превышать 100 символов")
    private String email;
    @NotEmpty
    @Size(max = 50,message = "Это поле не должно превышать 50 символов")
    private String name;
    @NotEmpty
    @Size(max = 50,message = "Это поле не должно превышать 50 символов")
    private String surName;

    private String password;

    public Users(String email, String name, String surName, String password) {
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

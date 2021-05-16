package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Email(message = "Некорректный e-mail")
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(max = 50,message = "Это поле не должно превышать 50 символов")
    private String name;
    @NotEmpty
    @Size(max = 50,message = "Это поле не должно превышать 50 символов")
    private String surName;

    @Size(min = 8, max = 15, message = "Пароль должнен быть не меньше 8 и не больше 15 символов")
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

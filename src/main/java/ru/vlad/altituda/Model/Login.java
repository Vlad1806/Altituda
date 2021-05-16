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
public class Login {

    @Email(message = "Некорректный e-mail")
    @NotEmpty
    private String email;
    @Size(min = 8, max = 15, message = "Пароль должнен быть не меньше 8 и не больше 15 символов")
    private String password;
}

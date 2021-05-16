package ru.vlad.altituda.JDBC;

import org.springframework.stereotype.Component;
import ru.vlad.altituda.Model.Users;

@Component
public class Registration {

    private static Users user;
    private static boolean registration = false;

    public static boolean isRegistration() {
        return registration;
    }

    public static Users getUsers(){
        return user;
    }
    public static void setRegistration(boolean registration,Users user) {
        Registration.user = user;
        Registration.registration = registration;
    }
}

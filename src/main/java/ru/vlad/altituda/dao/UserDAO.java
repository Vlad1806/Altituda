package ru.vlad.altituda.dao;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import ru.vlad.altituda.Model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static final String url = "jdbc:postgresql://localhost:5432/Altituda";
    private static final String username ="Vlad";
    private static final String  password ="12345";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public List<Users> index(){

        List<Users> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Users user = new Users();
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name_"));
                user.setSurName(resultSet.getString("surname"));
                user.setPassword(resultSet.getString("password_"));

                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public Users show(String email){
        Users user= new Users();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM " +
                            "users  WHERE email = ?");
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setEmail(resultSet.getString("email"));
                String password = resultSet.getString("password_");
                password = base64ApacheDecode(password);//////
                user.setName(resultSet.getString("name_"));
                user.setSurName(resultSet.getString("surname"));
                user.setPassword(password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void save(Users user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO users (email,name_,surname,password_)VALUES (?,?,?,?)");
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurName());
            preparedStatement.setString(4,base64ApacheEncode(user.getPassword()));

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void update(String email, Users users){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET name_=?,surname=?,password_= ? WHERE email = ?");
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getSurName());
            String pass = base64ApacheEncode(users.getPassword());
            preparedStatement.setString(3, pass);
            preparedStatement.setString(4,email);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String base64ApacheEncode(String st) {
        Base64 base64 = new Base64();
        String encodedString = new String(base64.encode(st.getBytes()));
        return encodedString;
    }

    public   String base64ApacheDecode(String st) {
        Base64 base64 = new Base64();
        String decodedString = new String(base64.decode(st.getBytes()));
        return decodedString;
    }

    public void delete(String email){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

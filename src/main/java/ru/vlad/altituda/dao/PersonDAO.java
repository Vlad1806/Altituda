package ru.vlad.altituda.dao;

import org.springframework.stereotype.Component;
import ru.vlad.altituda.Model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

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

    public List<Person> index(){

        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from Person";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id){
        Person person = new Person();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Person WHERE id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public void save(Person person){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO Person (name,age,email)VALUES (?,?,?)");

            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,person.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person updatePerson){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Person SET name=?,age=?,email=? WHERE id = ?");
            preparedStatement.setString(1,updatePerson.getName());
            preparedStatement.setInt(2,updatePerson.getAge());
            preparedStatement.setString(3,updatePerson.getEmail());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Person WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

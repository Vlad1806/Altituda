package ru.vlad.altituda.dao;

import org.springframework.stereotype.Component;
import ru.vlad.altituda.Model.Producer;
import ru.vlad.altituda.Model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProducerDAO {
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

    public List<Producer> index(){

        List<Producer> producers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM producer";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Producer producer = new Producer();
                producer.setId(resultSet.getInt("id_producer"));
                producer.setProducer(resultSet.getString("producer"));
                producers.add(producer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producers;
    }

    public Producer show(int id){
        Producer producer = new Producer();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM producer  WHERE id_producer = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                producer.setId(resultSet.getInt("id_producer"));
                producer.setProducer(resultSet.getString("producer"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producer;
    }

    public void save(Producer producer){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO producer (producer)VALUES (?)");
            preparedStatement.setString(1,producer.getProducer());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Producer producer){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE producer SET producer = ? WHERE id_producer = ?");
            preparedStatement.setString(1, producer.getProducer());
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM producer WHERE id_producer = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

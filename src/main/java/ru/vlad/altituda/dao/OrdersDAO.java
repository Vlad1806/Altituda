package ru.vlad.altituda.dao;

import org.springframework.stereotype.Component;
import ru.vlad.altituda.Model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersDAO {

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

    public List<Orders> index(){

        List<Orders> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Orders order = new Orders();
                order.setId(resultSet.getInt("id_order"));
                order.setProduct(resultSet.getInt("product_id"));
                order.setQuantity(resultSet.getInt("quantity"));
                order.setReceiving(resultSet.getString("date_receiving"));
                order.setTimeOrder(resultSet.getString("time_order"));

                orders.add(order);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public Orders show(int id){
        Orders order = new Orders();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM orders WHERE id_order =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                order.setId(resultSet.getInt("id_order"));
                order.setProduct(resultSet.getInt("product_id"));
                order.setQuantity(resultSet.getInt("quantity"));
                order.setReceiving(resultSet.getString("date_receiving"));
                order.setTimeOrder(resultSet.getString("time_order"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }


    public void save(Orders orders) {
        String query = "INSERT INTO orders " +
                " (product_id, quantity, date_receiving, time_order) " +
                " VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, orders.getProduct());
            preparedStatement.setInt(2, orders.getQuantity());
            Date k = Date.valueOf(orders.getReceiving());
            System.out.println(k);
            preparedStatement.setDate(3, Date.valueOf(orders.getReceiving()));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void update(int id, Orders updateOrders){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE orders SET product_id = ?, quantity=?, date_receiving =?, " +
                            "time_order=? WHERE id_order = ?");

            preparedStatement.setInt(1, updateOrders.getProduct());
            preparedStatement.setInt(2, updateOrders.getQuantity());
            preparedStatement.setDate(3, Date.valueOf(updateOrders.getReceiving()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(updateOrders.getTimeOrder()));
            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM orders WHERE id_order = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

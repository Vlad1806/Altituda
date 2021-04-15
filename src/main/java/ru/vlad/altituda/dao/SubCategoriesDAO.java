package ru.vlad.altituda.dao;

import org.springframework.stereotype.Component;;
import ru.vlad.altituda.Model.SubCategories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SubCategoriesDAO {

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
//    public List<SubCategories> index() {
//
//        List<SubCategories> subCategories = new ArrayList<>();
//        try (Connection connection = dbSource.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "SELECT id_subcategory,s.name_,s.description,c.name_ FROM " +
//                            "subcategories s")) {
//
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    while (resultSet.next()) {
//                        subCategories.add(new SubCategories(
//                                resultSet.getInt("id_subcategory"),
//                                resultSet.getString("s.name_"),
//                                resultSet.getString("s.description"),
//                                resultSet.getInt("c.name_")));
//                    }
//                }
//            }
//        } catch (SQLException | ClassNotFoundException throwable) {
//            throwable.printStackTrace();
//        }
//        return Collections.unmodifiableList(subCategories);
//    }
public List<SubCategories> index(){

    List<SubCategories> people = new ArrayList<>();
    try {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM " +
                           "subcategories";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            SubCategories SubCategories = new SubCategories();
            SubCategories.setId(resultSet.getInt("id_subcategory"));
            SubCategories.setName(resultSet.getString("name_"));
            SubCategories.setDescription(resultSet.getString("description"));
            SubCategories.setCategory(resultSet.getInt("category_id"));

            people.add(SubCategories);
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return people;
}
    public SubCategories show(int id){
        SubCategories subCategories= new SubCategories();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM " +
                            "subcategories  WHERE id_subcategory =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                subCategories.setId(resultSet.getInt("id_subcategory"));
                subCategories.setName(resultSet.getString("name_"));
                subCategories.setDescription(resultSet.getString("description"));
                subCategories.setCategory(resultSet.getInt("category_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subCategories;
    }
//    public SubCategories show(int id) {
//        SubCategories subCategories = new SubCategories();
//        try (Connection connection = dbSource.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "SELECT id_subcategory,s.name_,s.description,c.name_ FROM " +
//                            "subcategories s  WHERE id_subcategory =?")) {
//                preparedStatement.setInt(1, id);
//
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                        new SubCategories(
//                                resultSet.getInt("id_subcategory"),
//                                resultSet.getString("s.name_"),
//                                resultSet.getString("s.description"),
//                                resultSet.getInt("c.name_"));
//                }
//            }
//        } catch (SQLException | ClassNotFoundException throwable) {
//            throwable.printStackTrace();
//        }
//        return subCategories;
//    }

//    public void save(SubCategories subCategories) {
//        try (Connection connection = dbSource.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    ("INSERT INTO subcategories (name_,description,category_id)VALUES (?,?,?)"))) {
//
//                preparedStatement.setString(1, subCategories.getName());
//                preparedStatement.setString(2, subCategories.getDescription());
//                preparedStatement.setInt(3, subCategories.getCategory());
//
//                preparedStatement.executeUpdate();
//
//            }
//        }catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void save(SubCategories subCategories){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO subcategories (name_,description,category_id)VALUES (?,?,?)");

            preparedStatement.setString(1,subCategories.getName());
            preparedStatement.setString(2,subCategories.getDescription());
            preparedStatement.setInt(3,subCategories.getCategory());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public void update(int id, SubCategories updateSubCategories) {
//        if (updateSubCategories == null) throw new IllegalArgumentException("SubCategories must be set");
//        try (Connection connection = dbSource.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "UPDATE subcategories SET s.name_ =?,s.description=? category_id = ? WHERE id = ?")) {
//                preparedStatement.setString(1, updateSubCategories.getName());
//                preparedStatement.setString(2, updateSubCategories.getDescription());
//                preparedStatement.setInt(3, updateSubCategories.getCategory());
//                preparedStatement.setInt(4, id);
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException | ClassNotFoundException throwable) {
//            throwable.printStackTrace();
//        }
//    }

    public void update(int id, SubCategories updateSubCategories){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE subcategories SET name_ =?,description=?, category_id = ? WHERE id_subcategory = ?");
            preparedStatement.setString(1, updateSubCategories.getName());
            preparedStatement.setString(2, updateSubCategories.getDescription());
            preparedStatement.setInt(3, updateSubCategories.getCategory());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM subcategories WHERE id_subcategory = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    public void delete(int id) {
//        try (Connection connection = dbSource.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "DELETE FROM subcategories WHERE id = ?")) {
//                preparedStatement.setInt(1, id);
//                preparedStatement.executeUpdate();
//
//            }
//        } catch (SQLException | ClassNotFoundException throwable) {
//            throwable.printStackTrace();
//        }
//    }
}

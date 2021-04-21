package ru.vlad.altituda.dao;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import ru.vlad.altituda.Model.Categories;
import ru.vlad.altituda.Model.Producer;
import ru.vlad.altituda.Model.Product;
import ru.vlad.altituda.Model.SubCategories;

import java.sql.*;
import java.util.*;

@Component
public class ProductDAO {
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

    public List<Product> index(){

        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from product";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id_product"));
                product.setSubcategories(resultSet.getInt("subcategories_id"));
                product.setDescription(resultSet.getString("description"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setProducer(resultSet.getInt("producer"));
                product.setPhoto(resultSet.getString("photo"));
                product.setPrice(resultSet.getDouble("price"));

                products.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    private String description(Map map){
        return null;
    }


    public Product show(int id){
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM product WHERE id_product =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String description = resultSet.getString("description");
//                description = description.replaceAll("\\{","");
//                description = description.replaceAll("\\}","");
//                System.out.println(description);
//                JsonObject jsonObject = new JsonParser().parse(description).getAsJsonObject();
                product.setId(resultSet.getInt("id_product"));
                product.setSubcategories(resultSet.getInt("subcategories_id"));
                product.setDescription(description);
                product.setQuantity(resultSet.getInt("quantity"));
                product.setProducer(resultSet.getInt("producer"));
                product.setPhoto(resultSet.getString("photo"));
                product.setPrice(resultSet.getDouble("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public void save(Product product) {
        String query = "INSERT INTO product " +
                " (subcategories_id, description, quantity, producer, photo, price) " +
                " VALUES (?,to_json(?::jsonb),?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

//            File img = new File(product.getPhoto());
//
//            try (FileInputStream fin = new FileInputStream(img)) {

                preparedStatement.setInt(1, product.getSubcategories());
                preparedStatement.setObject(2, product.getDescription());
                preparedStatement.setInt(3, product.getQuantity());
                preparedStatement.setInt(4, product.getProducer());
                preparedStatement.setString(5,product.getPhoto());
                preparedStatement.setDouble(6, product.getPrice());

                preparedStatement.executeUpdate();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<SubCategories> allSubCategories(){

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

    public List<Producer> allProducer(){

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

    public void update(int id, Product updateProduct){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE product SET subcategories_id = ?, description =?::jsonb," +
                            " quantity=?, producer=?, photo=?, price=? " +
                            "WHERE id_product = ?");
//
//            System.out.println(updateProduct.getPhoto());
//            byte[] photobytes = updateProduct.getPhoto().getBytes();

            String description = updateProduct.getDescription();

//            File img = new File(updateProduct.getPhoto());
//            JsonObject jsonObject = new JsonParser().parse(description).getAsJsonObject();
//            try (FileInputStream fin = new FileInputStream(img)) {

                preparedStatement.setInt(1, updateProduct.getSubcategories());
                preparedStatement.setString(2, description);
                preparedStatement.setInt(3, updateProduct.getQuantity());
                preparedStatement.setInt(4, updateProduct.getProducer());
                preparedStatement.setString(5,updateProduct.getPhoto());
//                preparedStatement.setBinaryStream(5, fin, (int) img.length());
                preparedStatement.setDouble(6, updateProduct.getPrice());
                preparedStatement.setInt(7,id);

                preparedStatement.executeUpdate();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Categories> Categories(){

        List<Categories> category = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM categories";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Categories categories = new Categories();
                categories.setId(resultSet.getInt("id_category"));
                categories.setName(resultSet.getString("name_"));
                categories.setDescription(resultSet.getString("description"));

                category.add(categories);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    public List<SubCategories> subCategoriesByCategories(int id){
        List<SubCategories> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM " +
                            "subcategories  WHERE category_id =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                SubCategories subCategories= new SubCategories();
                subCategories.setId(resultSet.getInt("id_subcategory"));
                subCategories.setName(resultSet.getString("name_"));
                subCategories.setDescription(resultSet.getString("description"));
                subCategories.setCategory(resultSet.getInt("category_id"));
                list.add(subCategories);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Product> bySubCategory( int category,int sub){


        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product " +
        "join subcategories s on product.subcategories_id = s.id_subcategory " +
        "join categories c on c.id_category = s.category_id WHERE category_id = ? and subcategories_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,category);
            preparedStatement.setInt(2,sub);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                String description = resultSet.getString("description");
                Gson gson = new Gson();
                HashMap<String,Object> map = gson.fromJson(description, HashMap.class);
//                List<String> list = new ArrayList<String>(Collections.singleton(map.values().toString()));
                String dd="";
                int count = 0;
                for ( Map.Entry<String, Object> entry : map.entrySet()) {
                    if (count == 3) break;
                    dd += entry.getKey() + ": " + entry.getValue().toString() + " <span></span>  <br />";
                    count++;
//                    dd += entry.getValue() +" <br/>";
                    // do something with key and/or tab
                }
                product.setId(resultSet.getInt("id_product"));
                product.setSubcategories(resultSet.getInt("subcategories_id"));
                product.setDescription(resultSet.getString("name_") + " <br/> " + dd);
                product.setQuantity(resultSet.getInt("quantity"));
                product.setProducer(resultSet.getInt("producer"));
                product.setPhoto(resultSet.getString("photo"));
                product.setPrice(resultSet.getDouble("price"));

                products.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }


    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM product WHERE id_product = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

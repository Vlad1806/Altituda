package ru.vlad.altituda.JDBC;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public final class DbSource {

    private final Properties properties = new Properties();

    public  void load(final String filename) throws IOException {
        if (filename == null) throw new IllegalArgumentException("filename must be set");
        try(InputStream is = DbSource.class.getClassLoader().getResourceAsStream(filename)){
            properties.load(is);
        }
    }

    public DbSource() throws IOException {
        load("database.properties");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(
                properties.getProperty("database.url"),
                properties.getProperty("database.username"),
                properties.getProperty("database.password"));
    }
}

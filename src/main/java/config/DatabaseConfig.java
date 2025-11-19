package config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import exceptions.DatabaseNotFoundException;

public class DatabaseConfig {

    private DatabaseConfig() {
    }

    private static Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConfig.class.getResourceAsStream("/db.properties")) {
            System.out.println(input);
            if (input == null) {
                throw new DatabaseNotFoundException();
            }

            properties.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));
    }
}

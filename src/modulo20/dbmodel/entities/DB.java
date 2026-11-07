package modulo20.dbmodel.entities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import modulo20.dbmodel.exceptions.DbExceptions;

public class DB {
    private static Connection connection = null;

    private static Properties loadProperties() {
        try (FileInputStream fileStream = new FileInputStream("src/modulo20/dbmodel/properties/db.properties")) {
            Properties properties = new Properties();
            properties.load(fileStream);
            return properties;
        } catch (IOException e) {
            throw new DbExceptions(e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties);

            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
        return connection;
    }

    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
    }

    private static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
    }

    private static void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        closeResultSet(resultSet);
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    public static void closeAll(Connection connection, Statement statement, PreparedStatement preparedStatement,
            ResultSet resultSet) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }
}

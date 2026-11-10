package modulo20.dbmodel.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface MessageInterface {
    default void showMessageAboutRowsAffected(PreparedStatement preparedStatement, String message) throws SQLException{
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println(message + preparedStatement.getUpdateCount());
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    System.out.println("Generated ID: " + resultSet.getInt(1));
                }
            }
        } else {
            System.out.println("No rows affected!");
        }
    }
}

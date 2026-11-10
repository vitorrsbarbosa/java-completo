package modulo20.dbmodel.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import modulo20.dbmodel.entities.DB;
import modulo20.dbmodel.exceptions.DbException;
import modulo20.dbmodel.interfaces.DepartmentInterface;
import modulo20.dbmodel.interfaces.MessageInterface;

public class Department implements DepartmentInterface, MessageInterface {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void select() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DB.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM department");

            while (resultSet.next()) {
                System.out.println(
                        "Id: " + resultSet.getInt("Id") +
                                " -- Name: " + resultSet.getString("Name"));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction cancelled! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback transaction, " + e1.getMessage());
            }
        } finally {
            DB.closeAll(statement, resultSet);
        }
    }

    @Override
    public void insert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DB.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO department (Name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Kitchen");
            showMessageAboutRowsAffected(preparedStatement, "New Department inserted successfully!");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction cancelled! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback transaction, " + e1.getMessage());
            }
        } finally {
            DB.closeAll(preparedStatement, resultSet);
        }
    }

    @Override
    public void update() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DB.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Tecnology");
            preparedStatement.setInt(2, 2);

            showMessageAboutRowsAffected(preparedStatement, "Department updated successfully!");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction cancelled! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback transaction, " + e1.getMessage());
            }
        } finally {
            DB.closeAll(preparedStatement, resultSet);
        }
    }

    @Override
    public void delete() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DB.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("DELETE FROM department WHERE Id = ?",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, 7);
            showMessageAboutRowsAffected(preparedStatement,
                    "Department deleted successfully!");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction cancelled! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback transaction, " + e1.getMessage());
            }
        } finally {
            DB.closeAll(preparedStatement, resultSet);
        }
    }
}

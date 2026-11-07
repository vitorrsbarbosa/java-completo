package modulo20.dbmodel.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import modulo20.dbmodel.entities.DB;
import modulo20.dbmodel.exceptions.DbExceptions;
import modulo20.dbmodel.interfaces.DepartmentInterface;

public class Department implements DepartmentInterface {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void select() {
        try {
            connection = DB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM department");

            while (resultSet.next()) {
                System.out.println(
                        "Id: " + resultSet.getInt("Id") +
                                " -- Name: " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw new DbExceptions(e.getMessage());
        } finally {
            DB.closeAll(connection, statement, resultSet);
        }
    }

    @Override
    public void insert() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}

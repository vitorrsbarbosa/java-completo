package modulo20.dbmodel.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modulo20.dbmodel.entities.DB;
import modulo20.dbmodel.interfaces.SellerInterface;
import modulo20.dbmodel.exceptions.DbExceptions;

public class Seller implements SellerInterface {
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
            resultSet = statement.executeQuery("SELECT * FROM seller");

            while (resultSet.next()) {
                System.out.println(
                        "Id: " + resultSet.getInt("Id") +
                                " -- Name: " + resultSet.getString("Name") +
                                " -- Email: " + resultSet.getString("Email") +
                                " -- BirthDate: " + sdf.format(resultSet.getDate("BirthDate")) +
                                " -- BaseSalary: " + resultSet.getDouble("BaseSalary") +
                                " -- DepartmentId: " + resultSet.getInt("DepartmentId"));
            }
        } catch (SQLException e) {
            throw new DbExceptions(e.getMessage());
        } finally {
            DB.closeAll(connection, statement, resultSet);
        }
    }

    @Override
    public void insert() {
        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "insert into seller" +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                            "values" +
                            "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Vitor");
            preparedStatement.setString(2, "vitor@email.com");
            preparedStatement.setDate(3, new Date(sdf.parse("08/03/1994").getTime()));
            preparedStatement.setDouble(4, 5000.00);
            preparedStatement.setInt(5, 1);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                System.out.println("Done! Rows inserted: " + preparedStatement.getUpdateCount());
            } else {
                System.out.println("No rows affected!");
            }
        } catch (SQLException | ParseException e) {
            throw new DbExceptions(e.getMessage());
        } finally {
            DB.closeAll(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void update() {
        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE seller " +
                    "SET BaseSalary = BaseSalary + ? " +
                    "WHERE DepartmentId = ?", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, 250.00);
            preparedStatement.setInt(2, 5);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                System.out.println("Done! Rows updated: " + preparedStatement.getUpdateCount());
            } else {
                System.out.println("No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbExceptions(e.getMessage());
        } finally {
            DB.closeAll(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}

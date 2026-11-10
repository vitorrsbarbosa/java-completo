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
import modulo20.dbmodel.interfaces.MessageInterface;
import modulo20.dbmodel.interfaces.SellerInterface;
import modulo20.dbmodel.exceptions.DbException;

public class Seller implements SellerInterface, MessageInterface {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void select() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
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
            throw new DbException(e.getMessage());
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
            preparedStatement = connection.prepareStatement(
                    "insert into seller" +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                            "values" +
                            "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Asdf");
            preparedStatement.setString(2, "asdf@email.com");
            preparedStatement.setDate(3, new Date(sdf.parse("18/03/1992").getTime()));
            preparedStatement.setDouble(4, 1500.00);
            preparedStatement.setInt(5, 1);

            showMessageAboutRowsAffected(preparedStatement, "Done! Seller inserted: ");

        } catch (SQLException | ParseException e) {
            throw new DbException(e.getMessage());
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
            preparedStatement = connection.prepareStatement("UPDATE seller " +
                    "SET BaseSalary = BaseSalary + ? " +
                    "WHERE DepartmentId = ?", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, 500.00);
            preparedStatement.setInt(2, 5);

            showMessageAboutRowsAffected(preparedStatement, "Done! Seller updated ");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
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
            preparedStatement = connection.prepareStatement("DELETE FROM Seller " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, 1);

            showMessageAboutRowsAffected(preparedStatement, "Done! Rows deleted: ");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeAll(preparedStatement, resultSet);
        }
    }
}

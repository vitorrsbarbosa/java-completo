package modulo20.daoproject.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modulo20.daoproject.db.DB;
import modulo20.daoproject.model.dao.DepartmentDao;
import modulo20.daoproject.model.entities.Department;
import modulo20.dbmodel.exceptions.DbException;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSER INTO department (Name) VALUES (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getName());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = null;
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    obj.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM department WHERE Id =  ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM department WHERE Id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Department d = instantiateDepartment(rs);
                return d;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeAll(ps, rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM department ORDER BY Name");
            rs = ps.executeQuery();
            List<Department> departments = new ArrayList<>();
            while (rs.next()) {
                Department d = instantiateDepartment(rs);
                departments.add(d);
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeAll(ps, rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("DeptName"));
        return department;
    }
}

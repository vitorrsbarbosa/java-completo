package modulo20.daoproject.model.dao;

import modulo20.daoproject.model.dao.implementation.DepartmentDaoJDBC;
import modulo20.daoproject.model.dao.implementation.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC();
    }
}

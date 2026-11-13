package modulo20.daoproject.model.dao;

import java.util.List;

import modulo20.daoproject.model.entities.Department;
import modulo20.daoproject.model.entities.Seller;

public interface SellerDao {
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department d);
}

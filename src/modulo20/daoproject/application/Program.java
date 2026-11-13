package modulo20.daoproject.application;

import java.util.List;

import modulo20.daoproject.model.dao.DaoFactory;
import modulo20.daoproject.model.dao.SellerDao;
import modulo20.daoproject.model.entities.Department;
import modulo20.daoproject.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(1);
        System.out.println("----------------- Seller found with id -----------------");
        System.out.println(seller);

        System.out.println("----------------- Sellers from Department -----------------");
        Department dep = new Department(3,null);
        List<Seller> sellersByDept = sellerDao.findByDepartment(dep);
        sellersByDept.forEach(System.out::println);

        System.out.println("----------------- All Sellers  -----------------");
        List<Seller> allSellers = sellerDao.findAll();
        allSellers.forEach(System.out::println);

        
    }
}

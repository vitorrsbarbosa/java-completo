package modulo20.daoproject.application;

import modulo20.daoproject.model.dao.DaoFactory;
import modulo20.daoproject.model.dao.SellerDao;
import modulo20.daoproject.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(1);
        System.out.println("----------------- Seller found with id -----------------");
        System.out.println(seller);
    }
}

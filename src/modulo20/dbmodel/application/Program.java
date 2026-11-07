package modulo20.dbmodel.application;

import java.sql.Connection;

import modulo20.dbmodel.entities.DB;
import modulo20.dbmodel.services.Department;
import modulo20.dbmodel.services.Seller;

public class Program {
    public static void main(String args[]) {
        Seller seller = new Seller();
        Department department = new Department();

        seller.select();
        department.select();

    }
}

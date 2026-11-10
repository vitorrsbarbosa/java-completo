package modulo20.dbmodel.application;

import modulo20.dbmodel.entities.DB;
import modulo20.dbmodel.services.Department;
import modulo20.dbmodel.services.Seller;

public class Program {
    public static void main(String args[]) {
        run();

    }

    private static void run() {
        Seller seller = new Seller();
        Department department = new Department();

        try {
            printSection("Seller Operations");
            seller.select();
            printSection("Department Operations");
            department.select();
        } finally {
            DB.closeConnection();
        }
    }

    private static void printSection(String section) {
        System.out.println("\n--- " + section + " ---");
    }
}

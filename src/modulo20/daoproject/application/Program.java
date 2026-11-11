package modulo20.daoproject.application;

import java.util.Date;

import modulo20.daoproject.model.entities.Department;
import modulo20.daoproject.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        Department books = new Department(1, "Books");
        System.out.println(books);

        Seller vitor = new Seller(1, "Vitor", "vitor@email.com", new Date(), 3000.0, books);

        System.out.println(vitor);
    }
}

package modulo20.daoproject.application;

import modulo20.daoproject.model.entities.Department;

public class Program {
    public static void main(String[] args) {
        Department books = new Department(1, "Books");
        System.out.println(books);
    }
}

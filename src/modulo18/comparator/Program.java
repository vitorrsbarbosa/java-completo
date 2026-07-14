package modulo18.comparator;

import java.util.ArrayList;
import java.util.List;

import modulo18.comparator.entities.Product;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        // Sort by name
        list.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));

        for (Product p : list) {
            System.out.println(p.getName() + ", " + p.getPrice());
        }

        System.out.println("-------------------");

        // Sort by price
        list.sort(Program::compareProducts);

        list.forEach(System.out::println);;

    }

    private static int compareProducts(Product product1, Product product2) {
        return product1.getPrice().compareTo(product2.getPrice());
    }
}

package modulo18.predicate;

import java.util.ArrayList;
import java.util.List;

import modulo18.predicate.entities.Product;
import modulo18.predicate.utils.ProductPredicate;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Remover itens com valor igual ou superior a 100.00
        list.removeIf(p -> p.getPrice() >= 100.00);
        for (Product p : list) {
            System.out.println(p);
        }
    }
}

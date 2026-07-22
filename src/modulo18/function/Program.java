package modulo18.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modulo18.function.entities.Product;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
        // names.forEach(System.out::println);

        // Function<Product,String> function = p -> p.getName().toUpperCase();
        // List<String> upperCaseNames = list.stream().map(function).collect(Collectors.toList());
        // upperCaseNames.forEach(System.out::println);

        list.stream().map(p->p.getName().toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);;


    }
}

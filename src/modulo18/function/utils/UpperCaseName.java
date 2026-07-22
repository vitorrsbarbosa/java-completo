package modulo18.function.utils;

import java.util.function.Function;

import modulo18.function.entities.Product;

public class UpperCaseName implements Function<Product, String> {
    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}

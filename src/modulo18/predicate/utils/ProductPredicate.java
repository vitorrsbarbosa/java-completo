package modulo18.predicate.utils;

import java.util.function.Predicate;

import modulo18.predicate.entities.Product;

public class ProductPredicate implements Predicate<Product> {
    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.00;
    }

}

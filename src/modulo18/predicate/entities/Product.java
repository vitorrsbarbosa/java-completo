package modulo18.predicate.entities;

/**
 * Product
 */
public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }

    // public static boolean staticProductPredicate(Product product) {
    //     return product.getPrice() >= 100.00;
    // }

    public boolean productPredicate() {
        return price >= 100.00;
    }
}

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();

    private Map<String, Double> cart = new LinkedHashMap<>();
    private Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparingDouble(cart::get));
    public void addProductToCart(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, price);
        sortedCart.put(product, price);
    }

    public void displayProductsInOrder() {
        System.out.println("Products in Order of Addition:");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
    public void displayProductsSortedByPrice() {
        System.out.println("\nProducts Sorted by Price:");
        for (Map.Entry<String, Double> entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
    public double getProductPrice(String product) {
        return productPrices.getOrDefault(product, 0.0);
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProductToCart("Laptop", 999.99);
        shoppingCart.addProductToCart("Headphones", 49.99);
        shoppingCart.addProductToCart("Smartphone", 799.99);
        shoppingCart.addProductToCart("Tablet", 399.99);
        shoppingCart.addProductToCart("Smartwatch", 199.99);
        shoppingCart.displayProductsInOrder();

        shoppingCart.displayProductsSortedByPrice();
    }
}

package q;

import java.util.*;
import java.util.stream.Collectors;

class Sale {
    int productId;
    int quantity;
    double price;

    Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    int productId;
    double totalRevenue;

    ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductId: " + productId + ", Total Revenue: " + totalRevenue;
    }
}

public class P2 {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale(1, 15, 20.0),
            new Sale(2, 5, 30.0),
            new Sale(3, 12, 10.0),
            new Sale(4, 8, 25.0),
            new Sale(5, 20, 15.0)
        );

        List<ProductSales> productSales = sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
            .limit(5)
            .collect(Collectors.toList());

        productSales.forEach(System.out::println);
    }
}

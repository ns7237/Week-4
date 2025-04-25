import java.util.ArrayList;
import java.util.List;

interface Category {
    String getName();
}

enum BookCategory implements Category {
    FICTION, NONFICTION, EDUCATIONAL;

    public String getName() {
        return this.name();
    }
}

enum ClothingCategory implements Category {
    MENS, WOMENS, KIDS;

    public String getName() {
        return this.name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getName() {
        return this.name();
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Product: " + name + ", Category: " + category.getName() + ", Price: $" + price);
    }
}

class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 49.99, BookCategory.EDUCATIONAL);
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 29.99, ClothingCategory.MENS);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 599.99, GadgetCategory.MOBILE);

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        for (Product<? extends Category> p : catalog) {
            p.displayInfo();
        }

        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(shirt, 15);
        MarketplaceUtils.applyDiscount(phone, 5);

        System.out.println("\nAfter Discounts:");
        for (Product<? extends Category> p : catalog) {
            p.displayInfo();
        }
    }
}

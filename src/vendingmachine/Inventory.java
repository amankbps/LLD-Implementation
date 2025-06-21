package vendingmachine;

import vendingmachine.model.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private final Map<Product, Integer> products;

    public Inventory() {
        this.products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        this.products.put(product, quantity);
    }
    public void removeProduct(Product product) {
        this.products.remove(product);
    }
    public void updateProduct(Product product, int quantity) {
        this.products.put(product, quantity);
    }
    public int getQuantity(Product product) {
        return this.products.get(product);
    }
    public boolean isAvailable(Product product) {
        return this.products.containsKey(product) && this.products.get(product) > 0;
    }
}

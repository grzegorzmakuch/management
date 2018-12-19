package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    int productsAmount(Product products);
    Product getProductByName(String productName);


}

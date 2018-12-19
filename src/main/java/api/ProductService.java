package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Integer getProductsAmount();
    Product getProductByName(String productName);
    //boolean isProductOnWarehouse(String productName);
    //boolean isProductExist(String productName);

}

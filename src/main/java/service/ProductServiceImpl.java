package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Integer getProductsAmount() {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {
        for(Product product : products) {
            if(product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}

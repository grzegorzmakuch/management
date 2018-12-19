package service;

import api.ProductService;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "Mammut", 600f, 50f, "red", 5, 42, false));
        products.add(new Cloth(1l, "JackWolfskin", 900f, 100f, "black", 2, "XL", "Texapore"));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        //excepted
        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "Salewa", 350f, 35f, "black", 10, "L", "GoreTex"));
        products.add(new Boots(1l, "Salewa", 690f, 100f, "green", 6, 42, false));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(2l, "Spodnie", 430f, 33f, "white", 9, "M", "gore"));
        List<Product> listFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertNotEquals(products, listFromTestClass);
    }

    @Test
    public void testGetProductsAmountWithProducts() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "Mammut", 100f, 10f, "white", 5, "M", "other"));
        products.add(new Boots(2l, "Scarpa", 700f, 100f, "yellow", 1, 42, false));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        int result = productService.getProductsAmount();
        //expected
        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetProductsAmountWithoutProducts() {
        //is
        ProductServiceImpl productService = new ProductServiceImpl();
        //then
        int result = productService.getProductsAmount();
        //expected
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "mammut", 53f, 10f, "black", 15, "xl", "cotton");
        products.add(cloth);
        Product boots = new Boots(2l, "salewa", 700f, 500f, "yellow", 1, 42, false);
        products.add(boots);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByName("mammut");

        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "mammut", 53f, 10f, "black", 15, "xl", "cotton");
        products.add(cloth);
        Product boots = new Boots(2l, "salewa", 700f, 500f, "yellow", 1, 42, false);
        products.add(boots);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByName("wolfskin");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWarehouseWhenIs() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "mammut", 350f, 50f, "black", 3, 44, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductOnWarehouse = productService.isProductOnWarehouse("mammut");

//        Assert.assertEquals(true, isProductOnWarehouse);
        Assert.assertTrue(isProductOnWarehouse);
    }

    @Test
    public void testIsProductOnWarehouseWhenIsNot() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "mammut", 350f, 50f, "black", 3, 44, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductOnWarehouse = productService.isProductOnWarehouse("inny");

        Assert.assertFalse(isProductOnWarehouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "mammut", 350f, 50f, "black", 3, 44, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist("mammut");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "mammut", 350f, 50f, "black", 3, 44, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist("inny");

        Assert.assertFalse(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "mammut", 350f, 50f, "black", 3, 44, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist(1l);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(1l, "mammut", 350f, 50f, "black", 3, 44, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist(32l);

        Assert.assertFalse(isProductExist);
    }
}

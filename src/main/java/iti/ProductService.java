package iti;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{

    private List<Product> products;
    private static ProductService productService = null;
    private ProductService(){
        products = new ArrayList<Product>();
    }

    public static ProductService getInstance() {
        if(productService == null) {
            productService = new ProductService();
            return productService;
        }
        else {
            return productService;
        }
    }

    @Override
    public List<Product> getProduts() {
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}



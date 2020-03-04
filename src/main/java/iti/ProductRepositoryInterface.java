package iti;

import java.util.List;

public interface ProductRepositoryInterface {

    Product saveProduct(Product product);
    List<Product> findAllProducts();
}

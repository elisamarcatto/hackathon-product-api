package iti;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface ProductRepositoryInterface extends CrudRepository<Product, String> {

    Product saveProduct(Product product);
    List<Product> findAllProducts();
}

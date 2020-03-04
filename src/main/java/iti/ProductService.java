package iti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{

    ProductRepositoryInterface productRepositoryInterface;

    @Autowired
    public ProductService(@Qualifier("productRepository") ProductRepositoryInterface
                                  productRepositoryInter) {
        productRepositoryInterface = productRepositoryInter;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}



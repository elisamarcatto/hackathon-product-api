package iti;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface{

    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Product saveProduct(Product product) {
        Product productDb = entityManager.merge(product);
        product.setId(productDb.getId());
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        Query findAllQuery = entityManager.createQuery("SELECT e FROM Product e");
        return (List<Product>) findAllQuery.getResultList();
    }
}

package iti.service;

import iti.model.Product;
import iti.model.ProductMetaData;
import iti.db.repository.ProductRepositoryInterface;
import iti.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService{

    @Autowired
    ProductRepositoryInterface productRepositoryInterface;

    public ResponseEntity<HttpResponse> getAllProducts(){
        List<Product> products = productRepositoryInterface.findAllProducts();
        if (products == null) {
            return new ResponseEntity<HttpResponse>(
                    new HttpResponse("500",
                            "ERROR",
                            "Error fetching products details",
                            products
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return new ResponseEntity<HttpResponse>(
                new HttpResponse(
                        "200",
                        "SUCCESS",
                        "Products Details",
                        products
                ),
                HttpStatus.OK);
    }

    public ResponseEntity<HttpResponse> addProduct (Product product) {
        Product newProduct = productRepositoryInterface.saveProduct(product);

        ProductMetaData productMetaData = null;
        if (newProduct == null) {
            productMetaData = new ProductMetaData(product.getId(), product.getName());
            return new ResponseEntity<HttpResponse>(
                    new HttpResponse(
                            "500",
                            "ERROR",
                            "Task creation failed",
                            productMetaData),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        productMetaData = new ProductMetaData(newProduct.getId(), newProduct.getName());
        return new ResponseEntity<HttpResponse>(
                new HttpResponse(
                        "200",
                        "SUCCESS",
                        "Product created successfully",
                        productMetaData),
                HttpStatus.OK);
    }
}



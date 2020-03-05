package iti.service;

import iti.dto.ProductDetailsDTO;
import iti.model.Product;
import iti.db.repository.ProductRepository;
import iti.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<HttpResponse> getAllProducts(){
        Iterable<Product> products = productRepository.findAll();
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
        Product newProduct = productRepository.save(product);

        if (newProduct == null) {
            return new ResponseEntity<HttpResponse>(
                    new HttpResponse(
                            "500",
                            "ERROR",
                            "Product creation failed",
                            newProduct),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<HttpResponse>(
                new HttpResponse(
                        "201",
                        "SUCCESS",
                        "Product created successfully",
                        newProduct),
                HttpStatus.OK);
    }

    public ResponseEntity<ProductDetailsDTO> getProductDetail(String productId) {
       final Product productFound = productRepository.findBySku(productId);
       if (Objects.nonNull(productFound)){
           return ResponseEntity.ok(ProductDetailsDTO.fromProduct(productFound));
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



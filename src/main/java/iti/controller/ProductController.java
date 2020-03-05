package iti.controller;

import iti.http.HttpResponse;
import iti.model.Product;
import iti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/iti")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<HttpResponse> getAllProducts(
            @RequestParam(value = "version", required = false) String apiVersion) {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<HttpResponse> addProduct (
            @RequestBody Product newProduct,
            @RequestParam(value = "version", required = false) String apiVersion) {
        return productService.addProduct(newProduct);
    }
}

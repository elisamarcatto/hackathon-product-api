package iti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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

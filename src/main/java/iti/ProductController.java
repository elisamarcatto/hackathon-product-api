package iti;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/demo")
public class ProductController {

    private ProductServiceInterface productServiceInterface;

    public ProductController(ProductService productServ) {
        productServiceInterface = productServ;
    }

    @RequestMapping(value = "/products", method= RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts(){
        System.out.println(productServiceInterface.getAllProducts().size());
        return new ResponseEntity<List<Product>>(productServiceInterface.getAllProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        return (productServiceInterface.addProduct(product));
    }
}

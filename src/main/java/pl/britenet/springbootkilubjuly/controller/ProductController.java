package pl.britenet.springbootkilubjuly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campuslu.object.Product;
import pl.britenet.campuslu.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable int id) {
        return this.productService.getProduct(id);
    }

    @PostMapping
    public void createProduct(Product product) {
        // this.productService.createProduct(product);
    }

    @PutMapping
    public void updateProduct(Product product) {
        // this.productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        // this.productService.deleteProduct(product);
    }

}

package ru.kulikovskiy.products.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kulikovskiy.products.entity.Product;
import ru.kulikovskiy.products.model.ProductRequest;
import ru.kulikovskiy.products.service.ProductService;
import ru.kulikovskiy.products.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductServiceImpl productServiceImpl, ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> upsert(@RequestBody ProductRequest product) {
        if (product != null) {
            productService.upsert(product);
            return ResponseEntity.ok(product.getId());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Product> get(@RequestParam String id) {
        if (id != null) {
            Product product = productService.get(id);
            if (product == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(product);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam String id) {
        productService.delete(id);
        return ResponseEntity.ok(id);
    }
}

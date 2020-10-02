package ru.kulikovskiy.products.service;

import org.springframework.stereotype.Service;
import ru.kulikovskiy.products.entity.Product;
import ru.kulikovskiy.products.model.ProductRequest;
import ru.kulikovskiy.products.repository.ProductRepository;

import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void upsert(ProductRequest productRequest) {
        Product product = ofNullable(productRepository.findById(productRequest.getId())).get().orElse(new Product());
        product.setId(productRequest.getId());
        ofNullable(productRequest.getProductName()).ifPresent(product::setProductName);
        ofNullable(productRequest.getPrice()).ifPresent(product::setPrice);

        productRepository.save(product);
    }

    public Product get(String id) {
        try {
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void delete(String id) {
        Product product =productRepository.findById(id).get();
        if (product != null) {
            productRepository.delete(product);
        }
    }
}

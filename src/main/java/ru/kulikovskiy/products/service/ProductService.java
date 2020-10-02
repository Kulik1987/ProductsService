package ru.kulikovskiy.products.service;

import ru.kulikovskiy.products.entity.Product;
import ru.kulikovskiy.products.model.ProductRequest;

public interface ProductService {
    void upsert(ProductRequest product);

    Product get(String id);

    void delete(String id);
}

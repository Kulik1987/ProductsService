package ru.kulikovskiy.products.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kulikovskiy.products.entity.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
}

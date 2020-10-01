package ru.kulikovskiy.products.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String id;
    private String productName;
    private String price;
}

package ru.kulikovskiy.products.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private String price;
    @Column(name = "date")
    private Date date;
}

package ru.kulikovskiy.products.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    @Column(name = "date", updatable = false)
    private Date date;

    @PrePersist
    private void save() {
        this.date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}

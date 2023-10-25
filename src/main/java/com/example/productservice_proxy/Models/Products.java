package com.example.productservice_proxy.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel{
    private String title;
    private String prodDescription;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categories category;
    private String imageUrl;
    private double price;
}

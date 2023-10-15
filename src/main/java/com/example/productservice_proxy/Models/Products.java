package com.example.productservice_proxy.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products extends BaseModel{
    private String title;
    private String prodDescription;
    private Categories category;
    private String imageUrl;
    private double price;
}

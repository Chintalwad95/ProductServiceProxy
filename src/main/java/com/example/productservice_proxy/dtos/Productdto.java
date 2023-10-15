package com.example.productservice_proxy.dtos;

import com.example.productservice_proxy.Models.Categories;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Productdto {
    private String title;
    private String prodDescription;
    private Categories category;
    private String imageUrl;
    private double price;
}

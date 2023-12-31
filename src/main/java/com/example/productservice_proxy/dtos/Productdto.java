package com.example.productservice_proxy.dtos;

import com.example.productservice_proxy.Models.Categories;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Productdto {
    private Long id;
    private String title;
    private double price;
    private String Description;
    private String category;
    private String imageUrl;
    private RatingDto rating;
}

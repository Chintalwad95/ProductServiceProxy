package com.example.productservice_proxy.Clients.Fakestoreclient;

import com.example.productservice_proxy.Clients.IclientProductsDto;
import com.example.productservice_proxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakestoreProductDto implements IclientProductsDto {
    private Long id;
    private String title;
    private double price;
    private String Description;
    private String category;
    private String imageUrl;
    private RatingDto rating;
}

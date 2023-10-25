package com.example.productservice_proxy.Services;

import com.example.productservice_proxy.Clients.IclientProductsDto;
import com.example.productservice_proxy.Models.Products;
import com.example.productservice_proxy.dtos.Productdto;

import java.util.List;

public interface IProductService {

    List<Products> getAllProducts();

    Products addNewProduct(Products product);

    Products updateProduct(Long id, Products product);

    String deleteProduct();

    Products getSingleProduct(Long id);
}

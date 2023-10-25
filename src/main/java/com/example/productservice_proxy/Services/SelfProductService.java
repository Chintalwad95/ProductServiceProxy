package com.example.productservice_proxy.Services;

import com.example.productservice_proxy.Models.Products;
import com.example.productservice_proxy.Repositiries.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelfProductService implements IProductService{

    ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public List<Products> getAllProducts() {
        return null;
    }

    @Override
    public Products addNewProduct(Products product) {
        this.productRepo.save(product);
        return product;
    }

    @Override
    public Products updateProduct(Long id, Products product) {
        return null;
    }

    @Override
    public String deleteProduct() {
        return null;
    }

    @Override
    public Products getSingleProduct(Long id) {
        return null;
    }
}

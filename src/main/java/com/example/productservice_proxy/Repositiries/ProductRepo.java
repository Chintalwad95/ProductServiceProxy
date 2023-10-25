package com.example.productservice_proxy.Repositiries;

import com.example.productservice_proxy.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Products,Long> {

   Products save(Products product);
}

package com.example.productservice_proxy.Repositiries;

import com.example.productservice_proxy.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products,Long> {

   Products save(Products product);

   Products findById(long id);
   List<Products> findByTitle(String title);
    List<Products> findAllByIdIsBetween(long id1,long id2);
    List<Products> findAllByDeletedIsFalse();
}

package com.example.productservice_proxy.Repositiries;

import com.example.productservice_proxy.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categories,Long> {

    Categories save(Categories category);
    Categories findById(long id);
}

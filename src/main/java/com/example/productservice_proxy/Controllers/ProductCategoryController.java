package com.example.productservice_proxy.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class ProductCategoryController {
    @GetMapping()
    public String getProductCategories(){
        return "Showing all the product categories";
    }
    @GetMapping("/{categoryId}")
    public String getProductsInCategory(@PathVariable("categoryId") Long id){
        return "Showing products in the category "+id;
    }
}

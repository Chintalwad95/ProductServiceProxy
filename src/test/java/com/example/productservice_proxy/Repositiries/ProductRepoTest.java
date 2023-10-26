package com.example.productservice_proxy.Repositiries;

import com.example.productservice_proxy.Models.Categories;
import com.example.productservice_proxy.Models.Products;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ProductRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    void saveProductAndCategory2() {

        Categories categories = new Categories();
        categories.setName("Fashion");
        categories.setCatDescription("Fashion");



        Products products = new Products();
        products.setTitle("Tshirt");
        products.setProdDescription("Tshirt");
        products.setCategory(categories);
        productRepo.save(products);

    }
    @Test
    @Transactional
    void saveProductAndCategory() {

        Products products = new Products();
        products.setTitle("Iphone 13");
        products.setProdDescription("Iphone 13");
        productRepo.save(products);

        Categories categories = new Categories();
        categories.setName("Household");
        categories.setCatDescription("Household");
        categories.setProductList(List.of(products));
        categories = categoryRepo.save(categories);

//        Products products1 = new Products();
//        products1.setTitle("Iphone 12");
//        products1.setProdDescription("Iphone 12");
//        products1.setCategory(categories);
//        productRepo.save(products1);

        //Categories categories1 = categoryRepo.findById(categories.getId()).get();
        //List<Products> productsList = categories1.getProductList();
        //System.out.println("Debug");


    }

}
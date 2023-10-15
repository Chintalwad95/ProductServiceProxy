package com.example.productservice_proxy.Controllers;

import com.example.productservice_proxy.dtos.Productdto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/products")
public class ProductController {
    @GetMapping("")
    public String GetProducts(){
        return "Showing all the products";
    }
    @GetMapping ("/{id}")
    public String getProductDetails(@PathVariable("id") Long id){
        return "Showing product details "+id;
    }
    @PostMapping ()
    public String addNewProduct(@RequestBody Productdto productdto){
        return "Adding new product "+productdto;
    }
    @PutMapping  ("/{Productid}")
    public String updateProduct(@PathVariable("Productid") Long productid){
        return "Updating product "+productid+" with ";
    }
    @DeleteMapping("/{Productid}")
    public String deleteProduct(@PathVariable("Productid") Long productid){
        return "Deleting product "+productid;
    }
}

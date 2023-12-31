package com.example.productservice_proxy.Controllers;

import com.example.productservice_proxy.Clients.Fakestoreclient.FakestoreProductDto;
import com.example.productservice_proxy.Clients.IclientProductsDto;
import com.example.productservice_proxy.Models.Categories;
import com.example.productservice_proxy.Models.Products;
import com.example.productservice_proxy.Security.JwtObject;
import com.example.productservice_proxy.Security.TokenValidator;
import com.example.productservice_proxy.Services.IProductService;
import com.example.productservice_proxy.dtos.Productdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/products")
public class ProductController {

    IProductService productService; // Dependency Injection

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public List<Products> GetProducts(){

        return this.productService.getAllProducts();
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Products> getProductDetails(@Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String AuthToken, @PathVariable("id") Long id){
        try
        {   JwtObject jwtObject = null;
            if(AuthToken != null) {
                Optional<JwtObject> jwtObjectOptional = TokenValidator.validateToken(AuthToken);
                if(jwtObjectOptional.isEmpty()) {
                    // throw exception
                }
            jwtObject = jwtObjectOptional.get();

            }


            MultiValueMap<String,String> header = new LinkedMultiValueMap<>();
            header.add("contents", "Kuch bhi");
            header.add("Auth-token", "Shubham hai na");
            if(id < 1) {
                throw new IllegalArgumentException("Invalid ID");
            }
        //    Products product = this.productService.getSingleProduct(id,jwtObject);
        // Line no 58 can be used for further more role validation in the product service for a user.
            Products product = this.productService.getSingleProduct(id);
            ResponseEntity<Products> responseEntity = new ResponseEntity<>(product,header,HttpStatus.OK);
            return responseEntity;

        }
        catch(Exception e)
        {
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            throw  e;
        }


    }
    @PostMapping ()
    public ResponseEntity<Products> addNewProduct(@RequestBody Productdto productdto){
        Products products = getProduct(productdto);
        Products savedProduct = this.productService.addNewProduct(products);
        ResponseEntity<Products> responseEntity =  new ResponseEntity<>(savedProduct,HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping  ("/{Productid}")
    public Products updateProduct(@PathVariable("Productid") Long productid, @RequestBody Productdto productdto){

        Products product = new Products();
        product.setTitle(productdto.getTitle());
        product.setPrice(productdto.getPrice());
        product.setId(productdto.getId());
        product.setProdDescription(productdto.getDescription());
        product.setImageUrl(productdto.getImageUrl());
        product.setCategory(new Categories());
        product.getCategory().setName(productdto.getCategory());

        return this.productService.updateProduct(productid,product);
    }
    @DeleteMapping("/{Productid}")
    public String deleteProduct(@PathVariable("Productid") Long productid)
    {
        return "Deleting product "+productid;
    }
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("Kuch to phata hai re baba in controller", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private static Products getProduct(Productdto productdto) {
        Products products = new Products();
        products.setTitle(productdto.getTitle());
        products.setPrice(products.getPrice());
        products.setId(productdto.getId());
        Categories category = new Categories();
        category.setName(productdto.getCategory());
        products.setCategory(category);
        products.setImageUrl(productdto.getImageUrl());
        products.setProdDescription(productdto.getDescription());
        return products;
    }
}

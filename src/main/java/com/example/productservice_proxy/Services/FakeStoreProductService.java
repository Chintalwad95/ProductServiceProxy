package com.example.productservice_proxy.Services;

import com.example.productservice_proxy.Clients.Fakestoreclient.FakeStoreClient;
import com.example.productservice_proxy.Clients.IclientProductsDto;
import com.example.productservice_proxy.Clients.Fakestoreclient.FakestoreProductDto;
import com.example.productservice_proxy.Models.Categories;
import com.example.productservice_proxy.Models.Products;
import com.example.productservice_proxy.dtos.Productdto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    FakeStoreClient fakeStoreClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    @Override
    public Products getSingleProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreProductDto> productdto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakestoreProductDto.class, id);
        Products products = getProducts(productdto.getBody());
        return products;
    }



    @Override
    public List<Products> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<Productdto[]> productdto = restTemplate.getForEntity("https://fakestoreapi.com/products", Productdto[].class);
        List<FakestoreProductDto> fakestoreProductDto = fakeStoreClient.getAllProducts();
        List<Products> ans = new ArrayList<>();
        for(FakestoreProductDto productdto1 : fakestoreProductDto)
        {
            Products products = new Products();
            products.setTitle(productdto1.getTitle());
            products.setPrice(products.getPrice());
            products.setId(productdto1.getId());
            Categories category = new Categories();
            category.setName(productdto1.getCategory());
            products.setCategory(category);
            products.setImageUrl(productdto1.getImageUrl());
            products.setProdDescription(productdto1.getDescription());
            ans.add(products);

        }
        return ans;
    }

    @Override
    public Products addNewProduct(IclientProductsDto productdto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products", productdto, FakestoreProductDto.class);
        Products product = getProducts((FakestoreProductDto) productdto);
        return product;
    }

    @Override
    public Products updateProduct(Long productid, Products product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakestoreProductDto fakestoreProductDto = new FakestoreProductDto();
        fakestoreProductDto.setId(product.getId());
        fakestoreProductDto.setTitle(product.getTitle());
        fakestoreProductDto.setPrice(product.getPrice());
        fakestoreProductDto.setDescription(product.getProdDescription());
        fakestoreProductDto.setCategory(product.getCategory().getName());

        ResponseEntity<FakestoreProductDto> fakestoreProductDtoResponseEntity = requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}", fakestoreProductDto,
                FakestoreProductDto.class, productid);
        FakestoreProductDto fakestoreProductDto1 = fakestoreProductDtoResponseEntity.getBody();

        return getProducts(fakestoreProductDto1);
    }

    @Override
    public String deleteProduct() {
        return null;
    }
    private static Products getProducts(FakestoreProductDto productdto) {
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
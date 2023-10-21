package com.example.productservice_proxy.Clients.Fakestoreclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class FakeStoreClient {
    RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<FakestoreProductDto> getAllProducts(){

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreProductDto[]> productdto = restTemplate.getForEntity("https://fakestoreapi.com/products", FakestoreProductDto[].class);

        return Arrays.asList(productdto.getBody());

    }

}

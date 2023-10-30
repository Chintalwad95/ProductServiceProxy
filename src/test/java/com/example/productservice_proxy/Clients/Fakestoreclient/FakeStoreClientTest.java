package com.example.productservice_proxy.Clients.Fakestoreclient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FakeStoreClientTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Test
    @DisplayName("Integration test for getting the Null product")
    public void Test_NonexistingProductReturnNull(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreProductDto> productdto = restTemplate.getForEntity("https://fakestoreapi.com/products/0", FakestoreProductDto.class);
        assertNull(productdto.getBody());

    }

}
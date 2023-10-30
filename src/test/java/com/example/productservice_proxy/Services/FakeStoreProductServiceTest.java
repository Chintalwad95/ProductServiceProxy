package com.example.productservice_proxy.Services;

import com.example.productservice_proxy.Clients.Fakestoreclient.FakeStoreClient;
import com.example.productservice_proxy.Clients.Fakestoreclient.FakestoreProductDto;
import com.example.productservice_proxy.dtos.Productdto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FakeStoreProductServiceTest {
    @Autowired
    FakeStoreClient fakeStoreClient;
    @Test
    @DisplayName("Product List is not null")
    public void Test_GetAllProductsIsNotNull() {

        List<FakestoreProductDto> productdtoList = fakeStoreClient.getAllProducts();

        assertNotNull(productdtoList);

    }

}
package com.example.productservice_proxy.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenValidator {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public static Optional<JwtObject> validateToken(String token) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        /*
        Addtional validation such as role validation can be done here
         */

        return Optional.empty();
    }
}

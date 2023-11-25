package com.example.productservice_proxy.Security;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class JwtObject {
    private String email;
    private Long userId;
    private Date createdDate;
    private Date expirationDate;
    private List<Role> roles = new ArrayList<>();
}

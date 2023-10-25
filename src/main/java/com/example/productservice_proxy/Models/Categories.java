package com.example.productservice_proxy.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@Entity
public class Categories extends BaseModel {

    private String name;
    private String catDescription;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Products> productList;
}

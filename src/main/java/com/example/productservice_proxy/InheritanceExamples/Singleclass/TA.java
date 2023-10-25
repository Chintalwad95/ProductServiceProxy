package com.example.productservice_proxy.InheritanceExamples.Singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mpc_ta")
public class TA extends User {
    private int rating;
}

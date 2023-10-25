package com.example.productservice_proxy.InheritanceExamples.Tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")
public class TA extends User{
    private int rating;
}

package com.example.productservice_proxy.InheritanceExamples.Tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User{
    private int noOfClasses;
}

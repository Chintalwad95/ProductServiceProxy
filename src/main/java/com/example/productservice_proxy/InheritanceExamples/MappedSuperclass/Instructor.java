package com.example.productservice_proxy.InheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_instructor")
public class Instructor extends User {
    private int noOfClasses;
}

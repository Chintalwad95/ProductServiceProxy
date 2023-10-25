package com.example.productservice_proxy.InheritanceExamples.Singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mpc_mentor")
public class Mentor extends User {
    private int noOfMentees;
}

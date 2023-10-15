package com.example.productservice_proxy.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public abstract class BaseModel {

    private Long id;
    private Date created_at;
    private Date updated_at;
    private boolean isDeleted;

}

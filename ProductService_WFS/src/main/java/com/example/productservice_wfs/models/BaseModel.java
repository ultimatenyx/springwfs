package com.example.productservice_wfs.models;

import java.util.Date;

public class BaseModel {
    private long id;
    private String createdBy;
    private Date createdAt;
    private Boolean isDeleted; //This can be an Enum as well
}

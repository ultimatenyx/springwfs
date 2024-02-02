package com.example.productservice_wfs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;

}

package com.example.productservice_wfs.service;

import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService implements IProductService {
    RestTemplateBuilder restTemplate;

    @Autowired
    public ProductService(RestTemplateBuilder restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public FakeStoreProductResponse getProductById(Long productId) {
        FakeStoreProductResponse dto = restTemplate.build()
        .getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductResponse.class,productId).getBody();

        return dto;
    }
    public String getNewProductById(Long productId){
        return restTemplate.build()
                .getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductResponse.class,productId).toString();
    }

    @Override
    public List<FakeStoreProductResponse> getAllProducts() {
        return null;
    }
}

package com.example.productservice_wfs.service;

import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.models.Product;

import java.util.List;

public interface IProductService {
    FakeStoreProductResponse getProductById(Long productId);
    List<FakeStoreProductResponse> getAllProducts();
    String getNewProductById(Long productId);
}

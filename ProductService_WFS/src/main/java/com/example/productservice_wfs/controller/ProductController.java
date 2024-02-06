package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.CreateProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.service.IProductService;
import com.example.productservice_wfs.service.ProductService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;
    public ProductController(IProductService productService){
        this.productService = productService;
    }
    @GetMapping("/")
    public HttpEntity<List<FakeStoreProductResponse>> getAllProducts(){
        List<FakeStoreProductResponse> responseList = productService.getAllProducts();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    @PostMapping("/")
    public String createProduct(@RequestBody CreateProductRequestDTO dto){
        return "product created... + "+ dto.getProductName();
    }
    @GetMapping("/{productId}")
    public HttpEntity<FakeStoreProductResponse> getProductById(@PathVariable("productId") Long productId){
        FakeStoreProductResponse data = productService.getProductById(productId);

        if(Objects.isNull(data)){

            return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
        }

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("class-name","Integrating APIS");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/a/{productId}")
    public String getNewProductById(@PathVariable("productId") Long productId){
        return productService.getNewProductById(productId);
    }
}

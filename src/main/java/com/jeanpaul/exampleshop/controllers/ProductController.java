package com.jeanpaul.exampleshop.controllers;

import com.jeanpaul.exampleshop.entities.Product;
import com.jeanpaul.exampleshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity getAll(){
        return productService.getAll();
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Product product){
        return productService.save(product);
    }
}

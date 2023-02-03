package com.jeanpaul.exampleshop.services;

import com.jeanpaul.exampleshop.entities.Product;
import com.jeanpaul.exampleshop.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity getAll() {
        List<Product> products = productRepository.findAll();

        if(products.isEmpty()){
            log.warn("There is not products in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Looking products in database");
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    public ResponseEntity save(Product product) {
        if(product.getProductId() != null){
            log.warn("There must not be an ID in the create request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Creating a product");
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }
}

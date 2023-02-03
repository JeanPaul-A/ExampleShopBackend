package com.jeanpaul.exampleshop.services;

import com.jeanpaul.exampleshop.entities.Order;
import org.springframework.http.ResponseEntity;

public interface CRUDService {

    ResponseEntity getAll();

    ResponseEntity getById(Long id);

    ResponseEntity save(Object object);

    ResponseEntity saveA(Order order);
}

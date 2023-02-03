package com.jeanpaul.exampleshop.controllers;

import com.jeanpaul.exampleshop.entities.Order;
import com.jeanpaul.exampleshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        return orderService.getById(id);
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Order order){
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Order order, @PathVariable("id") Long id){
        return orderService.update(order, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        return orderService.delete(id);
    }
}

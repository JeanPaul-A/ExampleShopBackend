package com.jeanpaul.exampleshop.services;

import com.jeanpaul.exampleshop.entities.Order;
import com.jeanpaul.exampleshop.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService{

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity getAll(){
        List<Order> orders = orderRepository.findAll();

        if(orders.isEmpty()){
            log.warn("There is not orders in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Looking orders in database");
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    public ResponseEntity getById(Long id){
        Optional<Order> order = orderRepository.findById(id);

        if(order.isEmpty()){
            log.warn("There is not an order with that id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.warn("Looking an order in database");
        return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

    public ResponseEntity save(Order order) {
        if(order.getOrderId() != null){
            log.warn("There must not be an ID in the create request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        order.setCreated(Instant.now());

        log.info("Creating an order");
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
    }

    public ResponseEntity update(Order order, Long id){
        if(order.getOrderId() == null){
            log.warn("Trying to update an order but without ID");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!getById(id).getStatusCode().is2xxSuccessful()){
            log.warn("Trying to update a not exist order");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Updating an order");
        return new ResponseEntity<>(orderRepository.saveAndFlush(order), HttpStatus.OK);
    }

    public ResponseEntity delete(Long id) {
        if(id == null){
            log.warn("Trying to delete an order but without ID");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!getById(id).getStatusCode().is2xxSuccessful()){
            log.warn("Trying to delete a not exist order");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Deleting an order");
        orderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Schedule
    public void updateState(int timer){
        log.info("Updating state in orders with schedule");
        orderRepository.updateState(timer);
    };
}

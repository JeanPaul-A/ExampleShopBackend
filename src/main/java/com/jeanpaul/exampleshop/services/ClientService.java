package com.jeanpaul.exampleshop.services;

import com.jeanpaul.exampleshop.entities.Client;
import com.jeanpaul.exampleshop.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity getAll() {
        List<Client> clients = clientRepository.findAll();

        if(clients.isEmpty()){
            log.warn("There is not clients in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Looking clients in database");
        return new ResponseEntity<>(clients, HttpStatus.OK);

    }

    public ResponseEntity save(Client client) {
        if(client.getClientID() != null){
            log.warn("There must not be an ID in the create request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Creating a client");
        return new ResponseEntity<>(clientRepository.save(client), HttpStatus.CREATED);
    }
}

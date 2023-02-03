package com.jeanpaul.exampleshop.controllers;

import com.jeanpaul.exampleshop.entities.Client;
import com.jeanpaul.exampleshop.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("")
    public ResponseEntity getAll(){
        return clientService.getAll();
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Client client){
        return clientService.save(client);
    }
}

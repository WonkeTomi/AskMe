package com.askme.AskMe.controller;

import com.askme.AskMe.model.Client;
import com.askme.AskMe.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientServices clientServices;

    @GetMapping("/client/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable("id") Long id) {
        return Optional
                .ofNullable(clientServices.findClientById(id))
                .map(client -> ResponseEntity.ok().body(client))
                .orElse(ResponseEntity.status(500).build());
    }
}

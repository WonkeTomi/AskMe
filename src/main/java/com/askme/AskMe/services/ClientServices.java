package com.askme.AskMe.services;

import com.askme.AskMe.model.Client;
import com.askme.AskMe.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    ClientRepository clientRepository;

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

}

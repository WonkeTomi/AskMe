package com.askme.AskMe.services;

import com.askme.AskMe.model.Client;
import com.askme.AskMe.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ClientServices {

    @Autowired
    ClientRepository clientRepository;

    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username).orElse(null);
    }

}

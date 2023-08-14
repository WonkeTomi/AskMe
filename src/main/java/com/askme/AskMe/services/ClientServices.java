package com.askme.AskMe.services;

import com.askme.AskMe.model.Client;
import com.askme.AskMe.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ClientServices {

    private final ClientRepository clientRepository;

    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username).orElse(null);
    }

}

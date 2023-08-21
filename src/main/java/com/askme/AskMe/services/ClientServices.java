package com.askme.AskMe.services;

import com.askme.AskMe.model.Client;
import com.askme.AskMe.model.Question;
import com.askme.AskMe.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@AllArgsConstructor
public class ClientServices {

    private final ClientRepository clientRepository;

    public Client getClientByUsername(String username) {
        return clientRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void addQuestionToClientList(Long clinetId, Question question) {
        Client client = getClientById(clinetId);
        Set<Question> clientQuestions = client.getQuestions();
        clientQuestions.add(question);
        clientRepository.save(client);
    }

}

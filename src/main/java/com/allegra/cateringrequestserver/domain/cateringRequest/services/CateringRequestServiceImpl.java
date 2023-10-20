package com.allegra.cateringrequestserver.domain.cateringRequest.services;

import com.allegra.cateringrequestserver.domain.cateringRequest.models.Client;
import com.allegra.cateringrequestserver.domain.cateringRequest.repos.CateringRequestRepo;
import com.allegra.cateringrequestserver.domain.core.exceptions.ResourceCreationException;
import com.allegra.cateringrequestserver.domain.core.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateringRequestServiceImpl implements CateringRequestService {
    private CateringRequestRepo cateringRequestRepo;

    @Autowired
    public CateringRequestServiceImpl (CateringRequestRepo cateringRequestRepo){
        this.cateringRequestRepo = cateringRequestRepo;
    }

    @Override
    public Client create(Client client) throws ResourceCreationException {
        Optional<Client> optional = cateringRequestRepo.findByEmail(client.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Client with email exists: " + client.getEmail());
        client = cateringRequestRepo.save(client);
        return client;
    }

    @Override
    public Client getById(Long id) throws ResourceNotFoundException {
        Client client = cateringRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody With the Id: " + id));
        return client;
    }

    @Override
    public Client getByEmail(String email) throws ResourceNotFoundException {
        Client client = cateringRequestRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody With the Email: " + email));
        return client;
    }

    @Override
    public List<Client> getAll() {
        return cateringRequestRepo.findAll();
    }

    @Override
    public Client update(Long id, Client clientDetail) {
        Client client = getById(id);
        client.setFirstName(clientDetail.getFirstName());
        client.setLastName(clientDetail.getLastName());
        client.setEmail(clientDetail.getEmail());
        client.setEventDetails(clientDetail.getEventDetails());
        client = cateringRequestRepo.save(client);
        return client;
    }

    @Override
    public void delete(Long id) {
        Client client = getById(id);
        cateringRequestRepo.delete(client);

    }

}

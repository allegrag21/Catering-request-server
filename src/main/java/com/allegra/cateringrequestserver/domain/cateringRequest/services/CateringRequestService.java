package com.allegra.cateringrequestserver.domain.cateringRequest.services;

import com.allegra.cateringrequestserver.domain.cateringRequest.models.Client;
import com.allegra.cateringrequestserver.domain.core.exceptions.ResourceCreationException;
import com.allegra.cateringrequestserver.domain.core.exceptions.ResourceNotFoundException;


import java.util.List;

public interface CateringRequestService {
    Client create(Client client) throws ResourceCreationException;

    Client getById(Long id) throws ResourceNotFoundException;

    Client getByEmail(String email) throws ResourceNotFoundException;

    List<Client> getAll();

    Client update(Long id, Client clientDetail);

    void delete(Long id);

    }


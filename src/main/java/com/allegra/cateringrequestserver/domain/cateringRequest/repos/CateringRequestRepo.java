package com.allegra.cateringrequestserver.domain.cateringRequest.repos;

import com.allegra.cateringrequestserver.domain.cateringRequest.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CateringRequestRepo extends JpaRepository<Client, Long>{
    Optional<Client> findByEmail(String email);
}

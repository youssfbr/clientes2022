package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.Client;
import com.github.youssfbr.clients.domain.services.exceptions.ClientNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNameContaining(String name);

    default Client findByIdOrElseThrow(Long clientId) {
        return findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
    }

    boolean existsByEmail(String email);

}

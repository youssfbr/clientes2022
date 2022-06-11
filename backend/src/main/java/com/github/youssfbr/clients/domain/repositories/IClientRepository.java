package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.Client;
import com.github.youssfbr.clients.domain.services.exceptions.ClientNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {

    default Client findByIdOrElseThrow(Long clientId) {
        return findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
    }

}

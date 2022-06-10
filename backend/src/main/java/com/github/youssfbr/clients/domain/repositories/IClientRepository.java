package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface IClientRepository extends JpaRepository<Client, Long> {

    default Client findByIdOrElseThrow(Long clientId) {
        return findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
    }

}

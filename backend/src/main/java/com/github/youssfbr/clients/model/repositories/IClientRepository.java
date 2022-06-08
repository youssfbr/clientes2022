package com.github.youssfbr.clients.model.repositories;

import com.github.youssfbr.clients.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}

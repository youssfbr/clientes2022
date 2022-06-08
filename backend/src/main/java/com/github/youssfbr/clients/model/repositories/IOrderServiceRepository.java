package com.github.youssfbr.clients.model.repositories;

import com.github.youssfbr.clients.model.entities.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderServiceRepository extends JpaRepository<OrderService, Long> {
}

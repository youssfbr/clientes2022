package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderServiceRepository extends JpaRepository<OrderService, Long> {
}

package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}

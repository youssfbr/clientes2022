package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}

package com.github.youssfbr.clients.domain.services.interfaces;

import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> listAll();
    Category findById(Long id);
    MessageResponseDTO createCategory(Category category);
    MessageResponseDTO updateCategory(Long categoryId, Category categoryDto);

}

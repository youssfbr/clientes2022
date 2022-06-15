package com.github.youssfbr.clients.domain.services;

import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.entities.Category;
import com.github.youssfbr.clients.domain.repositories.ICategoryRepository;
import com.github.youssfbr.clients.domain.services.exceptions.CategoryNotFoundException;
import com.github.youssfbr.clients.domain.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    @Transactional
    public MessageResponseDTO createCategory(Category category) {

        Category savedCategory = categoryRepository.save(category);
        return createMessageResponse("Categoria criada com ID ", savedCategory.getId());
    }

    @Override
    @Transactional
    public MessageResponseDTO updateCategory(Long categoryId, Category categoryDto) {

        Category categoryEntity = findById(categoryId);
        BeanUtils.copyProperties(categoryDto, categoryEntity, "id");

        Category savedCategory = categoryRepository.save(categoryEntity);
        return createMessageResponse("Categoria atualizada com ID ", savedCategory.getId());
    }

    private MessageResponseDTO createMessageResponse(final String message, final Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}

package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.entities.Category;
import com.github.youssfbr.clients.domain.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping
    public List<Category> listall() {
        return categoryService.listAll();
    }

    @GetMapping("{categoryId}")
    public Category listById(@PathVariable Long categoryId) {
        return categoryService.findById(categoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("{categoryId}")
    public MessageResponseDTO update(@PathVariable long categoryId, @RequestBody @Valid Category category) {
        return categoryService.updateCategory(categoryId, category);
    }

}

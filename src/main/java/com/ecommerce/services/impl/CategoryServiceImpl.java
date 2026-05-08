package com.ecommerce.services.impl;

import com.ecommerce.dto.CategoryRequestDTO;
import com.ecommerce.dto.CategoryResponseDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.entities.Category;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO dto) {

        Category category = Category.builder()
                .name(dto.name())
                .build();

        Category saved = categoryRepository.save(category);

        return mapToDTO(saved);
    }

    @Override
    public List<CategoryResponseDTO> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO getById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        return mapToDTO(category);
    }

    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        category.setName(dto.name());

        Category updated = categoryRepository.save(category);

        return mapToDTO(updated);
    }

    @Override
    public void delete(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        categoryRepository.delete(category);
    }

    private CategoryResponseDTO mapToDTO(Category category) {

        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getProducts()
                        .stream()
                        .map(product -> new ProductResponseDTO(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getStock(),
                                category.getName(),
                                product.getCreatedAt()
                        ))
                        .toList()
        );
    }
}

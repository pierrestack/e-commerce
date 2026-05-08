package com.ecommerce.services;

import com.ecommerce.dto.CategoryRequestDTO;
import com.ecommerce.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO create(CategoryRequestDTO dto);

    List<CategoryResponseDTO> getAll();

    CategoryResponseDTO getById(Long id);

    CategoryResponseDTO update(Long id, CategoryRequestDTO dto);

    void delete(Long id);
}

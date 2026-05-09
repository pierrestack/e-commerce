package com.ecommerce.services.category;

import com.ecommerce.dto.category.CategoryRequestDTO;
import com.ecommerce.dto.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO create(CategoryRequestDTO dto);

    List<CategoryResponseDTO> getAll();

    CategoryResponseDTO getById(Long id);

    CategoryResponseDTO update(Long id, CategoryRequestDTO dto);

    void delete(Long id);
}

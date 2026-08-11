package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO create(ProductRequestDTO dto);

    List<ProductResponseDTO> getAll();

    ProductResponseDTO getById(Long id);

    ProductResponseDTO update(Long id, ProductRequestDTO dto);

    void delete(Long id);
}

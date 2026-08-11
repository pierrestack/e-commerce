package com.ecommerce.category.dto;

import com.ecommerce.product.dto.ProductResponseDTO;

import java.util.List;

public record CategoryResponseDTO(
        Long id,
        String name,
        List<ProductResponseDTO> products
) {
}

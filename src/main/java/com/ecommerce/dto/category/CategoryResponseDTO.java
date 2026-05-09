package com.ecommerce.dto.category;

import com.ecommerce.dto.product.ProductResponseDTO;

import java.util.List;

public record CategoryResponseDTO(
        Long id,
        String name,
        List<ProductResponseDTO> products
) {
}

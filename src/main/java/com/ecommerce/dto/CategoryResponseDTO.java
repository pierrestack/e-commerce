package com.ecommerce.dto;

import java.util.List;

public record CategoryResponseDTO(
        Long id,
        String name,
        List<ProductResponseDTO> products
) {
}

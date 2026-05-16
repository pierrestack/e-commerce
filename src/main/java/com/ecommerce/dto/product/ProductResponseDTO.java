package com.ecommerce.dto.product;

import com.ecommerce.dto.productImage.ProductImageResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        String category,
        LocalDateTime createdAt,
        List<ProductImageResponseDTO> images
) {
}

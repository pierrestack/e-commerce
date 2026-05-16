package com.ecommerce.dto.productImage;

import com.ecommerce.enums.ProductImageType;

import java.time.LocalDateTime;

public record ProductImageResponseDTO(
        Long id,

        String imageUrl,

        String altText,

        Integer displayOrder,

        ProductImageType type,

        LocalDateTime createdAt
) {
}

package com.ecommerce.productimage.dto;

import com.ecommerce.productimage.enums.ProductImageType;
import java.time.LocalDateTime;

public record ProductImageResponseDTO(
    Long id,
    String imageUrl,
    String altText,
    Integer displayOrder,
    ProductImageType type,
    LocalDateTime createdAt) {}

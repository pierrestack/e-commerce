package com.ecommerce.dto.productImage;

import com.ecommerce.enums.ProductImageType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductImageRequestDTO(
        @NotBlank(message = "Image URL is required")
        @Size(
                max = 1000,
                message = "Image URL must not exceed 1000 characters"
        )
        String imageUrl,

        @Size(
                max = 255,
                message = "Alt text must not exceed 255 characters"
        )
        String altText,

        @NotNull(message = "Display order is required")
        @Min(
                value = 0,
                message = "Display order must be greater than or equal to 0"
        )
        Integer displayOrder,

        @NotNull(message = "Image type is required")
        ProductImageType type

//        @NotNull(message = "Product ID is required")
//        Long productId
) {
}

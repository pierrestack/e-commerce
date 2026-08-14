package com.ecommerce.product.dto;

import com.ecommerce.productimage.dto.ProductImageRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

public record ProductRequestDTO(
    @NotBlank(message = "Name is required") String name,
    @NotBlank(message = "Description is required") String description,
    @NotNull(message = "Price is required") @Positive(message = "Price must be positive") BigDecimal price,
    @NotNull(message = "Stock is required") @Positive(message = "Stock must be positive") Integer stock,
    @NotNull(message = "Category ID is required") Long categoryId,
    @Valid List<ProductImageRequestDTO> images) {}

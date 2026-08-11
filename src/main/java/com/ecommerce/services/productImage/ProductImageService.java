package com.ecommerce.services.productImage;

import com.ecommerce.dto.product.ProductRequestDTO;
import com.ecommerce.dto.productImage.ProductImageRequestDTO;
import com.ecommerce.dto.productImage.ProductImageResponseDTO;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.ProductImage;

import java.util.List;

public interface ProductImageService {

    List<ProductImage> mapToEntities(ProductRequestDTO dto, Product product);

    List<ProductImageResponseDTO> getAll(Long id);

    ProductImageResponseDTO create(Long id, ProductImageRequestDTO dto);

    ProductImageResponseDTO update(Long id, ProductImageRequestDTO dto);

    void delete(Long id);
}

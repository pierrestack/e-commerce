package com.ecommerce.productimage.service;

import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.productimage.dto.ProductImageRequestDTO;
import com.ecommerce.productimage.dto.ProductImageResponseDTO;
import com.ecommerce.product.entity.Product;
import com.ecommerce.productimage.entity.ProductImage;

import java.util.List;

public interface ProductImageService {

    List<ProductImage> mapToEntities(ProductRequestDTO dto, Product product);

    List<ProductImageResponseDTO> getAll(Long id);

    ProductImageResponseDTO create(Long id, ProductImageRequestDTO dto);

    ProductImageResponseDTO update(Long id, ProductImageRequestDTO dto);

    void delete(Long id);
}

package com.ecommerce.services.productImage;

import com.ecommerce.dto.product.ProductRequestDTO;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.ProductImage;

import java.util.List;

public interface ProductImageService {

    List<ProductImage> mapToEntities(ProductRequestDTO dto, Product product);
}

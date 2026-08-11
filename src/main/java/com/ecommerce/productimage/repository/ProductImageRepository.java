package com.ecommerce.productimage.repository;

import com.ecommerce.productimage.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    Collection<ProductImage> findByProductId(Long id);
}

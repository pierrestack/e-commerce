package com.ecommerce.repositories;

import com.ecommerce.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    Collection<ProductImage> findByProductId(Long id);
}

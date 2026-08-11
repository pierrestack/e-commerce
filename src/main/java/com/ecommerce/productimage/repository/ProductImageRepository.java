package com.ecommerce.productimage.repository;

import com.ecommerce.productimage.entity.ProductImage;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
  Collection<ProductImage> findByProductId(Long id);
}

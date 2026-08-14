package com.ecommerce.product.service;

import com.ecommerce.category.entity.Category;
import com.ecommerce.category.repository.CategoryRepository;
import com.ecommerce.common.exception.ResourceNotFoundException;
import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.productimage.dto.ProductImageResponseDTO;
import com.ecommerce.productimage.entity.ProductImage;
import com.ecommerce.productimage.service.ProductImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final ProductImageService productImageService;

  @Override
  public ProductResponseDTO create(ProductRequestDTO dto) {

    Category category =
        categoryRepository
            .findById(dto.categoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

    Product product =
        Product.builder()
            .name(dto.name())
            .description(dto.description())
            .price(dto.price())
            .stock(dto.stock())
            .category(category)
            .build();

    List<ProductImage> images = productImageService.mapToEntities(dto, product);
    product.setImages(images);

    Product saved = productRepository.save(product);

    return mapToDTO(saved);
  }

  @Override
  public List<ProductResponseDTO> getAll() {

    return productRepository.findAll().stream().map(this::mapToDTO).toList();
  }

  @Override
  public ProductResponseDTO getById(Long id) {

    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    return mapToDTO(product);
  }

  @Override
  public ProductResponseDTO update(Long id, ProductRequestDTO dto) {

    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    Category category =
        categoryRepository
            .findById(dto.categoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

    product.setName(dto.name());
    product.setDescription(dto.description());
    product.setPrice(dto.price());
    product.setStock(dto.stock());
    product.setCategory(category);

    Product updated = productRepository.save(product);

    return mapToDTO(updated);
  }

  @Override
  public void delete(Long id) {

    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    productRepository.delete(product);
  }

  private ProductResponseDTO mapToDTO(Product product) {

    return new ProductResponseDTO(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getStock(),
        product.getCategory().getName(),
        product.getCreatedAt(),
        product.getImages().stream()
            .map(
                image ->
                    new ProductImageResponseDTO(
                        image.getId(),
                        image.getImageUrl(),
                        image.getAltText(),
                        image.getDisplayOrder(),
                        image.getType(),
                        image.getCreatedAt()))
            .toList());
  }
}

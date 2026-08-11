package com.ecommerce.services.productImage;

import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.dto.productImage.ProductImageRequestDTO;
import com.ecommerce.dto.productImage.ProductImageResponseDTO;
import com.ecommerce.product.entity.Product;
import com.ecommerce.entities.ProductImage;
import com.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.repositories.ProductImageRepository;
import com.ecommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    private final ProductRepository productRepository;

    @Override
    public List<ProductImage> mapToEntities(ProductRequestDTO dto, Product product) {

        if (dto.images() == null) {
            return List.of();
        }

        return dto.images()
                .stream()
                .map(imageRequest -> {

                    ProductImage image =
                            ProductImage.builder()
                                    .imageUrl(imageRequest.imageUrl())
                                    .altText(imageRequest.altText())
                                    .displayOrder(imageRequest.displayOrder())
                                    .type(imageRequest.type())
                                    .product(product)
                                    .build();
                    return image;
                })
                .toList();
    }

    @Override
    public List<ProductImageResponseDTO> getAll(Long id) {
        return productImageRepository.findByProductId(id)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ProductImageResponseDTO create(Long id, ProductImageRequestDTO dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        ProductImage productImage = ProductImage.builder()
                .imageUrl(dto.imageUrl())
                .altText(dto.altText())
                .displayOrder(dto.displayOrder())
                .type(dto.type())
                .product(product)
                .build();

        ProductImage productImageSaved = productImageRepository.save(productImage);

        return this.mapToDTO(productImageSaved);

    }

    @Override
    public ProductImageResponseDTO update(Long id, ProductImageRequestDTO dto) {

        ProductImage productImage = productImageRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product image not found"));

        productImage.setImageUrl(dto.imageUrl());
        productImage.setAltText(dto.altText());
        productImage.setDisplayOrder(dto.displayOrder());
        productImage.setType(dto.type());

        ProductImage updatedProductImage = productImageRepository.save(productImage);

        return this.mapToDTO(updatedProductImage);
    }

    @Override
    public void delete(Long id) {

        ProductImage productImage = productImageRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product image not found"));

        productImageRepository.delete(productImage);

    }

    private ProductImageResponseDTO mapToDTO(ProductImage productImage){
        return new ProductImageResponseDTO(
              productImage.getId(),
              productImage.getImageUrl(),
              productImage.getAltText(),
              productImage.getDisplayOrder(),
              productImage.getType(),
                productImage.getCreatedAt()
        );
    }
}

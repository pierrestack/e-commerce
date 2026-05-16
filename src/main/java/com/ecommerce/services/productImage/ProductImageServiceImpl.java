package com.ecommerce.services.productImage;

import com.ecommerce.dto.product.ProductRequestDTO;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
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
}

package com.ecommerce.productimage.controller;

import com.ecommerce.productimage.dto.ProductImageRequestDTO;
import com.ecommerce.productimage.dto.ProductImageResponseDTO;
import com.ecommerce.productimage.service.ProductImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @GetMapping("/{id}/images")
    public List<ProductImageResponseDTO> getAll(@PathVariable Long id){
        return productImageService.getAll(id);
    }

    @PostMapping("/{id}/images")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductImageResponseDTO create(@PathVariable Long id, @Valid @RequestBody ProductImageRequestDTO dto){

        return productImageService.create(id, dto);
    }

    @PutMapping("/images/{id}")
    public ProductImageResponseDTO update(@PathVariable Long id, @Valid @RequestBody ProductImageRequestDTO dto){
        return productImageService.update(id, dto);
    }

    @DeleteMapping("/images/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productImageService.delete(id);
    }
}

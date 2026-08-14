package com.ecommerce.product.controller;

import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;
import com.ecommerce.product.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponseDTO create(@Valid @RequestBody ProductRequestDTO dto) {
    return productService.create(dto);
  }

  @GetMapping
  public List<ProductResponseDTO> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public ProductResponseDTO getById(@PathVariable Long id) {
    return productService.getById(id);
  }

  @PutMapping("/{id}")
  public ProductResponseDTO update(
      @PathVariable Long id, @Valid @RequestBody ProductRequestDTO dto) {
    return productService.update(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }
}

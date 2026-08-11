package com.ecommerce.upload.controller;

import com.ecommerce.upload.dto.UploadResponseDTO;
import com.ecommerce.common.storage.ImageStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
public class UploadController {

    private final ImageStorageService imageStorageService;

    @PostMapping("/images")
    public ResponseEntity<UploadResponseDTO> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {

        String imageUrl = imageStorageService.uploadImage(file);

        return ResponseEntity.ok(
                new UploadResponseDTO(imageUrl)
        );
    }
}
